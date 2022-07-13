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

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;

/**
 * ChangeDetectionComponent
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-07-12T10:19:43.430893315+02:00[Europe/Rome]")
public class ChangeDetectionComponent {
    public static final String SERIALIZED_NAME_NAME = "name";
    public static final String SERIALIZED_NAME_TITLE = "title";
    public static final String SERIALIZED_NAME_DESCRIPTION = "description";
    public static final String SERIALIZED_NAME_TYPE = "type";
    public static final String SERIALIZED_NAME_PROPERTIES = "properties";
    @SerializedName(SERIALIZED_NAME_NAME)
    private String name;
    @SerializedName(SERIALIZED_NAME_TITLE)
    private String title;
    @SerializedName(SERIALIZED_NAME_DESCRIPTION)
    private String description;
    @SerializedName(SERIALIZED_NAME_TYPE)
    private ComponentType type;
    @SerializedName(SERIALIZED_NAME_PROPERTIES)
    private Map<String, Object> properties = new HashMap<String, Object>();

    public ChangeDetectionComponent() {
    }

    public ChangeDetectionComponent name(String name) {

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

    public ChangeDetectionComponent title(String title) {

        this.title = title;
        return this;
    }

    /**
     * Get title
     *
     * @return title
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(required = true, value = "")

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ChangeDetectionComponent description(String description) {

        this.description = description;
        return this;
    }

    /**
     * Get description
     *
     * @return description
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(required = true, value = "")

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ChangeDetectionComponent type(ComponentType type) {

        this.type = type;
        return this;
    }

    /**
     * Get type
     *
     * @return type
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(required = true, value = "")

    public ComponentType getType() {
        return type;
    }

    public void setType(ComponentType type) {
        this.type = type;
    }

    public ChangeDetectionComponent properties(Map<String, Object> properties) {

        this.properties = properties;
        return this;
    }

    public ChangeDetectionComponent putPropertiesItem(String key, Object propertiesItem) {
        this.properties.put(key, propertiesItem);
        return this;
    }

    /**
     * Get properties
     *
     * @return properties
     **/
    @javax.annotation.Nonnull
    @ApiModelProperty(required = true, value = "")

    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ChangeDetectionComponent changeDetectionComponent = (ChangeDetectionComponent) o;
        return Objects.equals(this.name, changeDetectionComponent.name) &&
            Objects.equals(this.title, changeDetectionComponent.title) &&
            Objects.equals(this.description, changeDetectionComponent.description) &&
            Objects.equals(this.type, changeDetectionComponent.type) &&
            Objects.equals(this.properties, changeDetectionComponent.properties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, title, description, type, properties);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ChangeDetectionComponent {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    title: ").append(toIndentedString(title)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    properties: ").append(toIndentedString(properties)).append("\n");
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

