
package com.szkolqa.boilerplate.testframework.api.pojo;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonPropertyOrder({
        "toAssign",
        "toActivate",
        "toDeactivate",
        "toUnassign"
})
public class Assignments {

    @JsonProperty("toAssign")
    private List<String> toAssign = null;
    @JsonProperty("toActivate")
    private List<String> toActivate = null;
    @JsonProperty("toDeactivate")
    private List<String> toDeactivate = null;
    @JsonProperty("toUnassign")
    private List<String> toUnassign = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("toAssign")
    public List<String> getToAssign() {
        return toAssign;
    }

    @JsonProperty("toAssign")
    public void setToAssign(List<String> toAssign) {
        this.toAssign = toAssign;
    }

    @JsonProperty("toActivate")
    public List<String> getToActivate() {
        return toActivate;
    }

    @JsonProperty("toActivate")
    public void setToActivate(List<String> toActivate) {
        this.toActivate = toActivate;
    }

    @JsonProperty("toDeactivate")
    public List<String> getToDeactivate() {
        return toDeactivate;
    }

    @JsonProperty("toDeactivate")
    public void setToDeactivate(List<String> toDeactivate) {
        this.toDeactivate = toDeactivate;
    }

    @JsonProperty("toUnassign")
    public List<String> getToUnassign() {
        return toUnassign;
    }

    @JsonProperty("toUnassign")
    public void setToUnassign(List<String> toUnassign) {
        this.toUnassign = toUnassign;
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
