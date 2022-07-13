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

import java.util.Map;
import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;

/**
 * ChangeDetection
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-07-12T10:19:43.430893315+02:00[Europe/Rome]")
public class ChangeDetection {
    public static final String SERIALIZED_NAME_ID = "id";
    public static final String SERIALIZED_NAME_MODEL = "model";
    public static final String SERIALIZED_NAME_CONFIG = "config";
    @SerializedName(SERIALIZED_NAME_ID)
    private Integer id;
    @SerializedName(SERIALIZED_NAME_MODEL)
    private String model;
    @SerializedName(SERIALIZED_NAME_CONFIG)
    private Map<String, ?> config;

    public ChangeDetection() {
    }

    public ChangeDetection id(Integer id) {

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

    public ChangeDetection model(String model) {

        this.model = model;
        return this;
    }

    /**
     * Get model
     *
     * @return model
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(required = true, value = "")

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public ChangeDetection config(Map<String, ?> config) {

        this.config = config;
        return this;
    }

    /**
     * Get config
     *
     * @return config
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(required = true, value = "")

    public Map<String, ?> getConfig() {
        return config;
    }

    public void setConfig(Map<String, ?> config) {
        this.config = config;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ChangeDetection changeDetection = (ChangeDetection) o;
        return Objects.equals(this.id, changeDetection.id) &&
            Objects.equals(this.model, changeDetection.model) &&
            Objects.equals(this.config, changeDetection.config);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, config);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ChangeDetection {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    model: ").append(toIndentedString(model)).append("\n");
        sb.append("    config: ").append(toIndentedString(config)).append("\n");
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

