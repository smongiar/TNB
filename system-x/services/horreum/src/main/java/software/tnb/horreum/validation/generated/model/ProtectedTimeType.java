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
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import jakarta.annotation.Generated;

/**
 * ProtectedTimeType
 */
@Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-12-02T20:53:38.158166061+01:00[Europe/Bratislava]",
    comments = "Generator version: 7.10.0")
public class ProtectedTimeType {
    public static final String SERIALIZED_NAME_ACCESS = "access";
    @SerializedName(SERIALIZED_NAME_ACCESS)
    @javax.annotation.Nonnull
    private Access access;

    public static final String SERIALIZED_NAME_OWNER = "owner";
    @SerializedName(SERIALIZED_NAME_OWNER)
    @javax.annotation.Nonnull
    private String owner;

    public static final String SERIALIZED_NAME_START = "start";
    @SerializedName(SERIALIZED_NAME_START)
    @javax.annotation.Nonnull
    private Long start;

    public static final String SERIALIZED_NAME_STOP = "stop";
    @SerializedName(SERIALIZED_NAME_STOP)
    @javax.annotation.Nonnull
    private Long stop;

    public ProtectedTimeType() {
    }

    public ProtectedTimeType access(@javax.annotation.Nonnull Access access) {
        this.access = access;
        return this;
    }

    /**
     * Access rights for the test. This defines the visibility of the Test in the UI
     *
     * @return access
     */
    @javax.annotation.Nonnull
    public Access getAccess() {
        return access;
    }

    public void setAccess(@javax.annotation.Nonnull Access access) {
        this.access = access;
    }

    public ProtectedTimeType owner(@javax.annotation.Nonnull String owner) {
        this.owner = owner;
        return this;
    }

    /**
     * Name of the team that owns the test. Users must belong to the team that owns a test to make modifications
     *
     * @return owner
     */
    @javax.annotation.Nonnull
    public String getOwner() {
        return owner;
    }

    public void setOwner(@javax.annotation.Nonnull String owner) {
        this.owner = owner;
    }

    public ProtectedTimeType start(@javax.annotation.Nonnull Long start) {
        this.start = start;
        return this;
    }

    /**
     * Run Start timestamp
     *
     * @return start
     */
    @javax.annotation.Nonnull
    public Long getStart() {
        return start;
    }

    public void setStart(@javax.annotation.Nonnull Long start) {
        this.start = start;
    }

    public ProtectedTimeType stop(@javax.annotation.Nonnull Long stop) {
        this.stop = stop;
        return this;
    }

    /**
     * Run Stop timestamp
     *
     * @return stop
     */
    @javax.annotation.Nonnull
    public Long getStop() {
        return stop;
    }

    public void setStop(@javax.annotation.Nonnull Long stop) {
        this.stop = stop;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProtectedTimeType protectedTimeType = (ProtectedTimeType) o;
        return Objects.equals(this.access, protectedTimeType.access) &&
            Objects.equals(this.owner, protectedTimeType.owner) &&
            Objects.equals(this.start, protectedTimeType.start) &&
            Objects.equals(this.stop, protectedTimeType.stop);
    }

    @Override
    public int hashCode() {
        return Objects.hash(access, owner, start, stop);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProtectedTimeType {\n");
        sb.append("    access: ").append(toIndentedString(access)).append("\n");
        sb.append("    owner: ").append(toIndentedString(owner)).append("\n");
        sb.append("    start: ").append(toIndentedString(start)).append("\n");
        sb.append("    stop: ").append(toIndentedString(stop)).append("\n");
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

    public static HashSet<String> openapiFields;
    public static HashSet<String> openapiRequiredFields;

    static {
        // a set of all properties/fields (JSON key names)
        openapiFields = new HashSet<String>();
        openapiFields.add("access");
        openapiFields.add("owner");
        openapiFields.add("start");
        openapiFields.add("stop");

        // a set of required properties/fields (JSON key names)
        openapiRequiredFields = new HashSet<String>();
        openapiRequiredFields.add("access");
        openapiRequiredFields.add("owner");
        openapiRequiredFields.add("start");
        openapiRequiredFields.add("stop");
    }

    /**
     * Validates the JSON Element and throws an exception if issues found
     *
     * @param jsonElement JSON Element
     * @throws IOException if the JSON Element is invalid with respect to ProtectedTimeType
     */
    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
        if (jsonElement == null) {
            if (!ProtectedTimeType.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
                throw new IllegalArgumentException(
                    String.format("The required field(s) %s in ProtectedTimeType is not found in the empty JSON string",
                        ProtectedTimeType.openapiRequiredFields.toString()));
            }
        }

        Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
        // check to see if the JSON string contains additional fields
        for (Map.Entry<String, JsonElement> entry : entries) {
            if (!ProtectedTimeType.openapiFields.contains(entry.getKey())) {
                throw new IllegalArgumentException(
                    String.format("The field `%s` in the JSON string is not defined in the `ProtectedTimeType` properties. JSON: %s", entry.getKey(),
                        jsonElement.toString()));
            }
        }

        // check to make sure all required properties/fields are present in the JSON string
        for (String requiredField : ProtectedTimeType.openapiRequiredFields) {
            if (jsonElement.getAsJsonObject().get(requiredField) == null) {
                throw new IllegalArgumentException(
                    String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
            }
        }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
        // validate the required field `access`
        Access.validateJsonElement(jsonObj.get("access"));
        if (!jsonObj.get("owner").isJsonPrimitive()) {
            throw new IllegalArgumentException(
                String.format("Expected the field `owner` to be a primitive type in the JSON string but got `%s`", jsonObj.get("owner").toString()));
        }
    }

    public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (!ProtectedTimeType.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes 'ProtectedTimeType' and its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<ProtectedTimeType> thisAdapter
                = gson.getDelegateAdapter(this, TypeToken.get(ProtectedTimeType.class));

            return (TypeAdapter<T>) new TypeAdapter<ProtectedTimeType>() {
                @Override
                public void write(JsonWriter out, ProtectedTimeType value) throws IOException {
                    JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
                    elementAdapter.write(out, obj);
                }

                @Override
                public ProtectedTimeType read(JsonReader in) throws IOException {
                    JsonElement jsonElement = elementAdapter.read(in);
                    validateJsonElement(jsonElement);
                    return thisAdapter.fromJsonTree(jsonElement);
                }
            }.nullSafe();
        }
    }

    /**
     * Create an instance of ProtectedTimeType given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of ProtectedTimeType
     * @throws IOException if the JSON string is invalid with respect to ProtectedTimeType
     */
    public static ProtectedTimeType fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, ProtectedTimeType.class);
    }

    /**
     * Convert an instance of ProtectedTimeType to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}

