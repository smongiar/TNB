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

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;

/**
 * RunExtended
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-07-12T10:19:43.430893315+02:00[Europe/Rome]")
public class RunExtended {
    public static final String SERIALIZED_NAME_OWNER = "owner";
    public static final String SERIALIZED_NAME_ACCESS = "access";
    public static final String SERIALIZED_NAME_TOKEN = "token";
    public static final String SERIALIZED_NAME_ID = "id";
    public static final String SERIALIZED_NAME_START = "start";
    public static final String SERIALIZED_NAME_STOP = "stop";
    public static final String SERIALIZED_NAME_DESCRIPTION = "description";
    public static final String SERIALIZED_NAME_TESTID = "testid";
    public static final String SERIALIZED_NAME_DATA = "data";
    public static final String SERIALIZED_NAME_TRASHED = "trashed";
    public static final String SERIALIZED_NAME_SCHEMA = "schema";
    public static final String SERIALIZED_NAME_TESTNAME = "testname";
    public static final String SERIALIZED_NAME_DATASETS = "datasets";
    @SerializedName(SERIALIZED_NAME_OWNER)
    private String owner;
    @SerializedName(SERIALIZED_NAME_ACCESS)
    private Access access;
    @SerializedName(SERIALIZED_NAME_TOKEN)
    private String token;
    @SerializedName(SERIALIZED_NAME_ID)
    private Integer id;
    @SerializedName(SERIALIZED_NAME_START)
    private BigDecimal start;
    @SerializedName(SERIALIZED_NAME_STOP)
    private BigDecimal stop;
    @SerializedName(SERIALIZED_NAME_DESCRIPTION)
    private String description;
    @SerializedName(SERIALIZED_NAME_TESTID)
    private Integer testid;
    @SerializedName(SERIALIZED_NAME_DATA)
    private List data;
    @SerializedName(SERIALIZED_NAME_TRASHED)
    private Boolean trashed;
    @SerializedName(SERIALIZED_NAME_SCHEMA)
    private List schema;
    @SerializedName(SERIALIZED_NAME_TESTNAME)
    private String testname;
    @SerializedName(SERIALIZED_NAME_DATASETS)
    private List<Integer> datasets = new ArrayList<Integer>();

    public RunExtended() {
    }

    public RunExtended owner(String owner) {

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

    public RunExtended access(Access access) {

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

    public RunExtended token(String token) {

        this.token = token;
        return this;
    }

    /**
     * Get token
     *
     * @return token
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public RunExtended id(Integer id) {

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

    public RunExtended start(BigDecimal start) {

        this.start = start;
        return this;
    }

    /**
     * Get start
     *
     * @return start
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(required = true, value = "")

    public BigDecimal getStart() {
        return start;
    }

    public void setStart(BigDecimal start) {
        this.start = start;
    }

    public RunExtended stop(BigDecimal stop) {

        this.stop = stop;
        return this;
    }

    /**
     * Get stop
     *
     * @return stop
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(required = true, value = "")

    public BigDecimal getStop() {
        return stop;
    }

    public void setStop(BigDecimal stop) {
        this.stop = stop;
    }

    public RunExtended description(String description) {

        this.description = description;
        return this;
    }

    /**
     * Get description
     *
     * @return description
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RunExtended testid(Integer testid) {

        this.testid = testid;
        return this;
    }

    /**
     * Get testid
     *
     * @return testid
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(required = true, value = "")

    public Integer getTestid() {
        return testid;
    }

    public void setTestid(Integer testid) {
        this.testid = testid;
    }

    public RunExtended data(List data) {

        this.data = data;
        return this;
    }

    /**
     * Get data
     *
     * @return data
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(required = true, value = "")

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

    public RunExtended trashed(Boolean trashed) {

        this.trashed = trashed;
        return this;
    }

    /**
     * Get trashed
     *
     * @return trashed
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(required = true, value = "")

    public Boolean getTrashed() {
        return trashed;
    }

    public void setTrashed(Boolean trashed) {
        this.trashed = trashed;
    }

    public RunExtended schema(List schema) {

        this.schema = schema;
        return this;
    }

    /**
     * Get schema
     *
     * @return schema
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(required = true, value = "")

    public List getSchema() {
        return schema;
    }

    public void setSchema(List schema) {
        this.schema = schema;
    }

    public RunExtended testname(String testname) {

        this.testname = testname;
        return this;
    }

    /**
     * Get testname
     *
     * @return testname
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(required = true, value = "")

    public String getTestname() {
        return testname;
    }

    public void setTestname(String testname) {
        this.testname = testname;
    }

    public RunExtended datasets(List<Integer> datasets) {

        this.datasets = datasets;
        return this;
    }

    public RunExtended addDatasetsItem(Integer datasetsItem) {
        this.datasets.add(datasetsItem);
        return this;
    }

    /**
     * Get datasets
     *
     * @return datasets
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(required = true, value = "")

    public List<Integer> getDatasets() {
        return datasets;
    }

    public void setDatasets(List<Integer> datasets) {
        this.datasets = datasets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RunExtended runExtended = (RunExtended) o;
        return Objects.equals(this.owner, runExtended.owner) &&
            Objects.equals(this.access, runExtended.access) &&
            Objects.equals(this.token, runExtended.token) &&
            Objects.equals(this.id, runExtended.id) &&
            Objects.equals(this.start, runExtended.start) &&
            Objects.equals(this.stop, runExtended.stop) &&
            Objects.equals(this.description, runExtended.description) &&
            Objects.equals(this.testid, runExtended.testid) &&
            Objects.equals(this.data, runExtended.data) &&
            Objects.equals(this.trashed, runExtended.trashed) &&
            Objects.equals(this.schema, runExtended.schema) &&
            Objects.equals(this.testname, runExtended.testname) &&
            Objects.equals(this.datasets, runExtended.datasets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner, access, token, id, start, stop, description, testid, data, trashed, schema, testname, datasets);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RunExtended {\n");
        sb.append("    owner: ").append(toIndentedString(owner)).append("\n");
        sb.append("    access: ").append(toIndentedString(access)).append("\n");
        sb.append("    token: ").append(toIndentedString(token)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    start: ").append(toIndentedString(start)).append("\n");
        sb.append("    stop: ").append(toIndentedString(stop)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    testid: ").append(toIndentedString(testid)).append("\n");
        sb.append("    data: ").append(toIndentedString(data)).append("\n");
        sb.append("    trashed: ").append(toIndentedString(trashed)).append("\n");
        sb.append("    schema: ").append(toIndentedString(schema)).append("\n");
        sb.append("    testname: ").append(toIndentedString(testname)).append("\n");
        sb.append("    datasets: ").append(toIndentedString(datasets)).append("\n");
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

