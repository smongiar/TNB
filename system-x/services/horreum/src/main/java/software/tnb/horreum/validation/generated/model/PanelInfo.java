/*
 * Horreum API
 * Horreum data repository API
 *
 * The version of the OpenAPI document: 0.1-SNAPSHOT
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package software.tnb.horreum.validation.generated.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;

/**
 * PanelInfo
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-07-12T10:19:43.430893315+02:00[Europe/Rome]")
public class PanelInfo {
    public static final String SERIALIZED_NAME_NAME = "name";
    public static final String SERIALIZED_NAME_VARIABLES = "variables";
    @SerializedName(SERIALIZED_NAME_NAME)
    private String name;
    @SerializedName(SERIALIZED_NAME_VARIABLES)
    private List<Variable> variables = new ArrayList<Variable>();

    public PanelInfo() {
    }

    public PanelInfo name(String name) {

        this.name = name;
        return this;
    }

    /**
     * Get name
     *
     * @return name
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(required = true, value = "")

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PanelInfo variables(List<Variable> variables) {

        this.variables = variables;
        return this;
    }

    public PanelInfo addVariablesItem(Variable variablesItem) {
        this.variables.add(variablesItem);
        return this;
    }

    /**
     * Get variables
     *
     * @return variables
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(required = true, value = "")

    public List<Variable> getVariables() {
        return variables;
    }

    public void setVariables(List<Variable> variables) {
        this.variables = variables;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PanelInfo panelInfo = (PanelInfo) o;
        return Objects.equals(this.name, panelInfo.name) &&
            Objects.equals(this.variables, panelInfo.variables);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, variables);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PanelInfo {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    variables: ").append(toIndentedString(variables)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}

