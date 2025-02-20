/*
 * Horreum REST API
 * Horreum automated change anomaly detection. For more information, please see [https://horreum.hyperfoil.io/](https://horreum.hyperfoil.io/)
 *
 * The version of the OpenAPI document: 0.17
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package software.tnb.horreum.validation.generated.model;

import software.tnb.horreum.validation.generated.JSON;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import jakarta.annotation.Generated;

/**
 * ConditionComponent
 */
@Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-12-02T20:53:38.158166061+01:00[Europe/Bratislava]",
    comments = "Generator version: 7.10.0")
public class ConditionComponent {
    public static final String SERIALIZED_NAME_NAME = "name";
    public static final String SERIALIZED_NAME_TITLE = "title";
    public static final String SERIALIZED_NAME_DESCRIPTION = "description";
    public static final String SERIALIZED_NAME_TYPE = "type";
    public static final String SERIALIZED_NAME_PROPERTIES = "properties";
    public static HashSet<String> openapiFields;
    public static HashSet<String> openapiRequiredFields;

    static {
        // a set of all properties/fields (JSON key names)
        openapiFields = new HashSet<String>();
        openapiFields.add("name");
        openapiFields.add("title");
        openapiFields.add("description");
        openapiFields.add("type");
        openapiFields.add("properties");

        // a set of required properties/fields (JSON key names)
        openapiRequiredFields = new HashSet<String>();
        openapiRequiredFields.add("name");
        openapiRequiredFields.add("title");
        openapiRequiredFields.add("description");
        openapiRequiredFields.add("type");
        openapiRequiredFields.add("properties");
    }

    @SerializedName(SERIALIZED_NAME_NAME)
    @javax.annotation.Nonnull
    private String name;
    @SerializedName(SERIALIZED_NAME_TITLE)
    @javax.annotation.Nonnull
    private String title;
    @SerializedName(SERIALIZED_NAME_DESCRIPTION)
    @javax.annotation.Nonnull
    private String description;
    @SerializedName(SERIALIZED_NAME_TYPE)
    @javax.annotation.Nonnull
    private TypeEnum type;
    @SerializedName(SERIALIZED_NAME_PROPERTIES)
    @javax.annotation.Nonnull
    private Map<String, Object> properties = new HashMap<>();

    public ConditionComponent() {
    }

    /**
     * Validates the JSON Element and throws an exception if issues found
     *
     * @param jsonElement JSON Element
     * @throws IOException if the JSON Element is invalid with respect to ConditionComponent
     */
    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
        if (jsonElement == null) {
            if (!ConditionComponent.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
                throw new IllegalArgumentException(
                    String.format("The required field(s) %s in ConditionComponent is not found in the empty JSON string",
                        ConditionComponent.openapiRequiredFields.toString()));
            }
        }

        Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
        // check to see if the JSON string contains additional fields
        for (Map.Entry<String, JsonElement> entry : entries) {
            if (!ConditionComponent.openapiFields.contains(entry.getKey())) {
                throw new IllegalArgumentException(
                    String.format("The field `%s` in the JSON string is not defined in the `ConditionComponent` properties. JSON: %s", entry.getKey(),
                        jsonElement.toString()));
            }
        }

        // check to make sure all required properties/fields are present in the JSON string
        for (String requiredField : ConditionComponent.openapiRequiredFields) {
            if (jsonElement.getAsJsonObject().get(requiredField) == null) {
                throw new IllegalArgumentException(
                    String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
            }
        }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
        if (!jsonObj.get("name").isJsonPrimitive()) {
            throw new IllegalArgumentException(
                String.format("Expected the field `name` to be a primitive type in the JSON string but got `%s`", jsonObj.get("name").toString()));
        }
        if (!jsonObj.get("title").isJsonPrimitive()) {
            throw new IllegalArgumentException(
                String.format("Expected the field `title` to be a primitive type in the JSON string but got `%s`", jsonObj.get("title").toString()));
        }
        if (!jsonObj.get("description").isJsonPrimitive()) {
            throw new IllegalArgumentException(
                String.format("Expected the field `description` to be a primitive type in the JSON string but got `%s`",
                    jsonObj.get("description").toString()));
        }
        // validate the required field `type`
        TypeEnum.validateJsonElement(jsonObj.get("type"));
    }

    /**
     * Create an instance of ConditionComponent given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of ConditionComponent
     * @throws IOException if the JSON string is invalid with respect to ConditionComponent
     */
    public static ConditionComponent fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, ConditionComponent.class);
    }

    public ConditionComponent name(@javax.annotation.Nonnull String name) {
        this.name = name;
        return this;
    }

    /**
     * Change detection model component name
     *
     * @return name
     */
    @javax.annotation.Nonnull
    public String getName() {
        return name;
    }

    public void setName(@javax.annotation.Nonnull String name) {
        this.name = name;
    }

    public ConditionComponent title(@javax.annotation.Nonnull String title) {
        this.title = title;
        return this;
    }

    /**
     * Change detection model component title
     *
     * @return title
     */
    @javax.annotation.Nonnull
    public String getTitle() {
        return title;
    }

    public void setTitle(@javax.annotation.Nonnull String title) {
        this.title = title;
    }

    public ConditionComponent description(@javax.annotation.Nonnull String description) {
        this.description = description;
        return this;
    }

    /**
     * Change detection model component description
     *
     * @return description
     */
    @javax.annotation.Nonnull
    public String getDescription() {
        return description;
    }

    public void setDescription(@javax.annotation.Nonnull String description) {
        this.description = description;
    }

    public ConditionComponent type(@javax.annotation.Nonnull TypeEnum type) {
        this.type = type;
        return this;
    }

    /**
     * UI Component type
     *
     * @return type
     */
    @javax.annotation.Nonnull
    public TypeEnum getType() {
        return type;
    }

    public void setType(@javax.annotation.Nonnull TypeEnum type) {
        this.type = type;
    }

    public ConditionComponent properties(@javax.annotation.Nonnull Map<String, Object> properties) {
        this.properties = properties;
        return this;
    }

    public ConditionComponent putPropertiesItem(String key, Object propertiesItem) {
        if (this.properties == null) {
            this.properties = new HashMap<>();
        }
        this.properties.put(key, propertiesItem);
        return this;
    }

    /**
     * Map of properties for component
     *
     * @return properties
     */
    @javax.annotation.Nonnull
    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(@javax.annotation.Nonnull Map<String, Object> properties) {
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
        ConditionComponent conditionComponent = (ConditionComponent) o;
        return Objects.equals(this.name, conditionComponent.name) &&
            Objects.equals(this.title, conditionComponent.title) &&
            Objects.equals(this.description, conditionComponent.description) &&
            Objects.equals(this.type, conditionComponent.type) &&
            Objects.equals(this.properties, conditionComponent.properties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, title, description, type, properties);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ConditionComponent {\n");
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

    /**
     * Convert an instance of ConditionComponent to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }

    /**
     * UI Component type
     */
    @JsonAdapter(TypeEnum.Adapter.class)
    public enum TypeEnum {
        LOG_SLIDER("LOG_SLIDER"),

        ENUM("ENUM"),

        NUMBER_BOUND("NUMBER_BOUND"),

        SWITCH("SWITCH");

        private Object value;

        TypeEnum(Object value) {
            this.value = value;
        }

        public static TypeEnum fromValue(Object value) {
            for (TypeEnum b : TypeEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }

        /**
         * Generated jsonElement.getAsObject() is not part of the gson library.
         * I have replaced method with .getAsString() which is compatible
         * with gson library but may not work in each case. Should be fixed in OAPI GEN 7.5.
         */
        public static void validateJsonElement(JsonElement jsonElement) throws IOException {
            //Object value = jsonElement.getAsObject();
            Object value = jsonElement.getAsString();
            TypeEnum.fromValue(value);
        }

        public Object getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static class Adapter extends TypeAdapter<TypeEnum> {
            /**
             * Generated jsonWriter.value(Object value) is not part of the gson library.
             * I have replaced method parameter for enumeration.toString() which is compatible
             * with gson library but may not work in every case. Should be fixed in OAPI GEN 7.5.
             */
            @Override
            public void write(final JsonWriter jsonWriter, final TypeEnum enumeration) throws IOException {
                //jsonWriter.value(enumeration.getValue());
                jsonWriter.value(enumeration.toString());
            }

            /**
             * Generated jsonReader.nextObject() is not part of the gson library
             * and is a bug in openapi generator 7.1. I have replaced method with
             * .nextString() which may not work in every case. Should be fixed in OAPI GEN 7.5.
             */
            @Override
            public TypeEnum read(final JsonReader jsonReader) throws IOException {
                //Object value = jsonReader.nextObject();
                Object value = jsonReader.nextString();
                return TypeEnum.fromValue(value);
            }
        }
    }

    public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (!ConditionComponent.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes 'ConditionComponent' and its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<ConditionComponent> thisAdapter
                = gson.getDelegateAdapter(this, TypeToken.get(ConditionComponent.class));

            return (TypeAdapter<T>) new TypeAdapter<ConditionComponent>() {
                @Override
                public void write(JsonWriter out, ConditionComponent value) throws IOException {
                    JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
                    elementAdapter.write(out, obj);
                }

                @Override
                public ConditionComponent read(JsonReader in) throws IOException {
                    JsonElement jsonElement = elementAdapter.read(in);
                    validateJsonElement(jsonElement);
                    return thisAdapter.fromJsonTree(jsonElement);
                }
            }.nullSafe();
        }
    }
}

