package com.szkolqa.boilerplate.testframework.api;

import com.szkolqa.boilerplate.testframework.api.pojo.Assignments;
import com.szkolqa.boilerplate.testframework.api.pojo.DecisionTree;
import com.szkolqa.boilerplate.testframework.api.pojo.tree.Tree;
import com.szkolqa.boilerplate.testframework.convert.JsonConverter;
import com.szkolqa.boilerplate.testframework.testdata.AssignmentsTestData;
import com.szkolqa.boilerplate.testframework.webelements.WebElementHandler;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Api {
    private String jSessionId;
    private OkHttpClient client = new OkHttpClient();
    private String baseUrl;
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private static Logger logger = LoggerFactory.getLogger(WebElementHandler.class);


    public Api(String baseUrl, String jSessionId) {
        this.baseUrl = baseUrl;
        this.jSessionId = jSessionId;
    }

    public void createBlankTree(String treeName, int modelId) {
        DecisionTree decisionTree = new DecisionTree();
        decisionTree.setName(treeName);
        decisionTree.setModelId(modelId);
        try {
            String response = post(baseUrl + "api/decision-tree", JsonConverter.toJsonString(decisionTree));
            logger.info("CreateBlankTree response:" + response);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    public void removeAllUsedAssignments() {
        Tree activeTrees = null;
        Tree inactiveTrees = null;
        try {
            activeTrees = JsonConverter.fromJSON(get(baseUrl + "api/decision-trees?active=true"), Tree.class);
            inactiveTrees = JsonConverter.fromJSON(get(baseUrl + "api/decision-trees?active=false"), Tree.class);
        } catch (Exception e) {
            logger.error("Error on getting trees in API");
        }
        List<Integer> treesIds = new ArrayList<>();
        Objects.requireNonNull(activeTrees).getResults().forEach(x -> treesIds.add(x.getId()));
        Objects.requireNonNull(inactiveTrees).getResults().forEach(x -> treesIds.add(x.getId()));
        for (int id : treesIds) {
            removeAllUsedAssignments(id);
        }
    }

    private void removeAllUsedAssignments(int treeId) {
        Assignments assignments = new Assignments();
        assignments.setToDeactivate(AssignmentsTestData.getAllAssignments());
        assignments.setToUnassign(AssignmentsTestData.getAllAssignments());
        try {
            String response = post(baseUrl + "api/decision-tree/" + treeId + "/assignments", JsonConverter.toJsonString(assignments));
            logger.info("CreateBlankTree response:" + response);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    private String get(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .addHeader("cookie", "JSESSIONID=" + jSessionId)
                .addHeader("Content-Type", "application/json")
                .addHeader("authority", "sens.silenteight.com")
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    private String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .addHeader("cookie", "JSESSIONID=" + jSessionId)
                .addHeader("Content-Type", "application/json")
                .addHeader("authority", "sens.silenteight.com")
                .post(body)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }
}
