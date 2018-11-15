
package com.szkolqa.boilerplate.testframework.api.pojo.tree;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name",
    "active",
    "status",
    "model",
    "summary",
    "agents",
    "activeReasoningBranches",
    "totalReasoningBranches",
    "assignments",
    "activations",
    "matchAlerts"
})
public class Result {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("active")
    private Boolean active;
    @JsonProperty("status")
    private Status status;
    @JsonProperty("model")
    private Model model;
    @JsonProperty("summary")
    private Object summary;
    @JsonProperty("agents")
    private List<String> agents = null;
    @JsonProperty("activeReasoningBranches")
    private Integer activeReasoningBranches;
    @JsonProperty("totalReasoningBranches")
    private Integer totalReasoningBranches;
    @JsonProperty("assignments")
    private List<String> assignments = null;
    @JsonProperty("activations")
    private List<Object> activations = null;
    @JsonProperty("matchAlerts")
    private Integer matchAlerts;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("active")
    public Boolean getActive() {
        return active;
    }

    @JsonProperty("active")
    public void setActive(Boolean active) {
        this.active = active;
    }

    @JsonProperty("status")
    public Status getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(Status status) {
        this.status = status;
    }

    @JsonProperty("model")
    public Model getModel() {
        return model;
    }

    @JsonProperty("model")
    public void setModel(Model model) {
        this.model = model;
    }

    @JsonProperty("summary")
    public Object getSummary() {
        return summary;
    }

    @JsonProperty("summary")
    public void setSummary(Object summary) {
        this.summary = summary;
    }

    @JsonProperty("agents")
    public List<String> getAgents() {
        return agents;
    }

    @JsonProperty("agents")
    public void setAgents(List<String> agents) {
        this.agents = agents;
    }

    @JsonProperty("activeReasoningBranches")
    public Integer getActiveReasoningBranches() {
        return activeReasoningBranches;
    }

    @JsonProperty("activeReasoningBranches")
    public void setActiveReasoningBranches(Integer activeReasoningBranches) {
        this.activeReasoningBranches = activeReasoningBranches;
    }

    @JsonProperty("totalReasoningBranches")
    public Integer getTotalReasoningBranches() {
        return totalReasoningBranches;
    }

    @JsonProperty("totalReasoningBranches")
    public void setTotalReasoningBranches(Integer totalReasoningBranches) {
        this.totalReasoningBranches = totalReasoningBranches;
    }

    @JsonProperty("assignments")
    public List<String> getAssignments() {
        return assignments;
    }

    @JsonProperty("assignments")
    public void setAssignments(List<String> assignments) {
        this.assignments = assignments;
    }

    @JsonProperty("activations")
    public List<Object> getActivations() {
        return activations;
    }

    @JsonProperty("activations")
    public void setActivations(List<Object> activations) {
        this.activations = activations;
    }

    @JsonProperty("matchAlerts")
    public Integer getMatchAlerts() {
        return matchAlerts;
    }

    @JsonProperty("matchAlerts")
    public void setMatchAlerts(Integer matchAlerts) {
        this.matchAlerts = matchAlerts;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
