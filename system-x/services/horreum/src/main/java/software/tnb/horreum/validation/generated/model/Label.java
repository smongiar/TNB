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
 * Label
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-07-12T10:19:43.430893315+02:00[Europe/Rome]")
public class Label {
    public static final String SERIALIZED_NAME_OWNER = "owner";
    public static final String SERIALIZED_NAME_ACCESS = "access";
    public static final String SERIALIZED_NAME_ID = "id";
    public static final String SERIALIZED_NAME_NAME = "name";
    public static final String SERIALIZED_NAME_EXTRACTORS = "extractors";
    public static final String SERIALIZED_NAME_FUNCTION = "function";
    public static final String SERIALIZED_NAME_FILTERING = "filtering";
    public static final String SERIALIZED_NAME_METRICS = "metrics";
    public static final String SERIALIZED_NAME_SCHEMA_ID = "schemaId";
    @SerializedName(SERIALIZED_NAME_OWNER)
    private String owner;
    @SerializedName(SERIALIZED_NAME_ACCESS)
    private Access access;
    @SerializedName(SERIALIZED_NAME_ID)
    private Integer id;
    @SerializedName(SERIALIZED_NAME_NAME)
    private String name;
    @SerializedName(SERIALIZED_NAME_EXTRACTORS)
    private List<Extractor> extractors = new ArrayList<Extractor>();
    @SerializedName(SERIALIZED_NAME_FUNCTION)
    private String function;
    @SerializedName(SERIALIZED_NAME_FILTERING)
    private Boolean filtering;
    @SerializedName(SERIALIZED_NAME_METRICS)
    private Boolean metrics;
    @SerializedName(SERIALIZED_NAME_SCHEMA_ID)
    private Integer schemaId;

    public Label() {
    }

    public Label owner(String owner) {

        this.owner = owner;
        return this;
    }

    /**
     * Get owner
     *
     * @return owner
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(required = true, value = "")

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Label access(Access access) {

        this.access = access;
        return this;
    }

    /**
     * Get access
     *
     * @return access
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(required = true, value = "")

    public Access getAccess() {
        return access;
    }

    public void setAccess(Access access) {
        this.access = access;
    }

    public Label id(Integer id) {

        this.id = id;
        return this;
    }

    /**
     * Get id
     *
     * @return id
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(required = true, value = "")

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Label name(String name) {

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

    public Label extractors(List<Extractor> extractors) {

        this.extractors = extractors;
        return this;
    }

    public Label addExtractorsItem(Extractor extractorsItem) {
        this.extractors.add(extractorsItem);
        return this;
    }

    /**
     * Get extractors
     *
     * @return extractors
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(required = true, value = "")

    public List<Extractor> getExtractors() {
        return extractors;
    }

    public void setExtractors(List<Extractor> extractors) {
        this.extractors = extractors;
    }

    public Label function(String function) {

        this.function = function;
        return this;
    }

    /**
     * Get function
     *
     * @return function
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public Label filtering(Boolean filtering) {

        this.filtering = filtering;
        return this;
    }

    /**
     * Get filtering
     *
     * @return filtering
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(required = true, value = "")

    public Boolean getFiltering() {
        return filtering;
    }

    public void setFiltering(Boolean filtering) {
        this.filtering = filtering;
    }

    public Label metrics(Boolean metrics) {

        this.metrics = metrics;
        return this;
    }

    /**
     * Get metrics
     *
     * @return metrics
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(required = true, value = "")

    public Boolean getMetrics() {
        return metrics;
    }

    public void setMetrics(Boolean metrics) {
        this.metrics = metrics;
    }

    public Label schemaId(Integer schemaId) {

        this.schemaId = schemaId;
        return this;
    }

    /**
     * Get schemaId
     *
     * @return schemaId
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(required = true, value = "")

    public Integer getSchemaId() {
        return schemaId;
    }

    public void setSchemaId(Integer schemaId) {
        this.schemaId = schemaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Label label = (Label) o;
        return Objects.equals(this.owner, label.owner) &&
            Objects.equals(this.access, label.access) &&
            Objects.equals(this.id, label.id) &&
            Objects.equals(this.name, label.name) &&
            Objects.equals(this.extractors, label.extractors) &&
            Objects.equals(this.function, label.function) &&
            Objects.equals(this.filtering, label.filtering) &&
            Objects.equals(this.metrics, label.metrics) &&
            Objects.equals(this.schemaId, label.schemaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner, access, id, name, extractors, function, filtering, metrics, schemaId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Label {\n");
        sb.append("    owner: ").append(toIndentedString(owner)).append("\n");
        sb.append("    access: ").append(toIndentedString(access)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    extractors: ").append(toIndentedString(extractors)).append("\n");
        sb.append("    function: ").append(toIndentedString(function)).append("\n");
        sb.append("    filtering: ").append(toIndentedString(filtering)).append("\n");
        sb.append("    metrics: ").append(toIndentedString(metrics)).append("\n");
        sb.append("    schemaId: ").append(toIndentedString(schemaId)).append("\n");
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

