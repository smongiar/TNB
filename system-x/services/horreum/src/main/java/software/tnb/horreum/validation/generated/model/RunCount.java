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
 * RunCount
 */
@Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-12-02T20:53:38.158166061+01:00[Europe/Bratislava]",
    comments = "Generator version: 7.10.0")
public class RunCount {
    public static final String SERIALIZED_NAME_TOTAL = "total";
    @SerializedName(SERIALIZED_NAME_TOTAL)
    @javax.annotation.Nonnull
    private Long total;

    public static final String SERIALIZED_NAME_ACTIVE = "active";
    @SerializedName(SERIALIZED_NAME_ACTIVE)
    @javax.annotation.Nonnull
    private Long active;

    public static final String SERIALIZED_NAME_TRASHED = "trashed";
    @SerializedName(SERIALIZED_NAME_TRASHED)
    @javax.annotation.Nonnull
    private Long trashed;

    public RunCount() {
    }

    public RunCount total(@javax.annotation.Nonnull Long total) {
        this.total = total;
        return this;
    }

    /**
     * Total count of Runs visible
     *
     * @return total
     */
    @javax.annotation.Nonnull
    public Long getTotal() {
        return total;
    }

    public void setTotal(@javax.annotation.Nonnull Long total) {
        this.total = total;
    }

    public RunCount active(@javax.annotation.Nonnull Long active) {
        this.active = active;
        return this;
    }

    /**
     * Total count of active Runs visible
     *
     * @return active
     */
    @javax.annotation.Nonnull
    public Long getActive() {
        return active;
    }

    public void setActive(@javax.annotation.Nonnull Long active) {
        this.active = active;
    }

    public RunCount trashed(@javax.annotation.Nonnull Long trashed) {
        this.trashed = trashed;
        return this;
    }

    /**
     * Total count of trashed Runs
     *
     * @return trashed
     */
    @javax.annotation.Nonnull
    public Long getTrashed() {
        return trashed;
    }

    public void setTrashed(@javax.annotation.Nonnull Long trashed) {
        this.trashed = trashed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RunCount runCount = (RunCount) o;
        return Objects.equals(this.total, runCount.total) &&
            Objects.equals(this.active, runCount.active) &&
            Objects.equals(this.trashed, runCount.trashed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(total, active, trashed);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RunCount {\n");
        sb.append("    total: ").append(toIndentedString(total)).append("\n");
        sb.append("    active: ").append(toIndentedString(active)).append("\n");
        sb.append("    trashed: ").append(toIndentedString(trashed)).append("\n");
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
        openapiFields.add("total");
        openapiFields.add("active");
        openapiFields.add("trashed");

        // a set of required properties/fields (JSON key names)
        openapiRequiredFields = new HashSet<String>();
        openapiRequiredFields.add("total");
        openapiRequiredFields.add("active");
        openapiRequiredFields.add("trashed");
    }

    /**
     * Validates the JSON Element and throws an exception if issues found
     *
     * @param jsonElement JSON Element
     * @throws IOException if the JSON Element is invalid with respect to RunCount
     */
    public static void validateJsonElement(JsonElement jsonElement) throws IOException {
        if (jsonElement == null) {
            if (!RunCount.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
                throw new IllegalArgumentException(String.format("The required field(s) %s in RunCount is not found in the empty JSON string",
                    RunCount.openapiRequiredFields.toString()));
            }
        }

        Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
        // check to see if the JSON string contains additional fields
        for (Map.Entry<String, JsonElement> entry : entries) {
            if (!RunCount.openapiFields.contains(entry.getKey())) {
                throw new IllegalArgumentException(
                    String.format("The field `%s` in the JSON string is not defined in the `RunCount` properties. JSON: %s", entry.getKey(),
                        jsonElement.toString()));
            }
        }

        // check to make sure all required properties/fields are present in the JSON string
        for (String requiredField : RunCount.openapiRequiredFields) {
            if (jsonElement.getAsJsonObject().get(requiredField) == null) {
                throw new IllegalArgumentException(
                    String.format("The required field `%s` is not found in the JSON string: %s", requiredField, jsonElement.toString()));
            }
        }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
    }

    public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (!RunCount.class.isAssignableFrom(type.getRawType())) {
                return null; // this class only serializes 'RunCount' and its subtypes
            }
            final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
            final TypeAdapter<RunCount> thisAdapter
                = gson.getDelegateAdapter(this, TypeToken.get(RunCount.class));

            return (TypeAdapter<T>) new TypeAdapter<RunCount>() {
                @Override
                public void write(JsonWriter out, RunCount value) throws IOException {
                    JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
                    elementAdapter.write(out, obj);
                }

                @Override
                public RunCount read(JsonReader in) throws IOException {
                    JsonElement jsonElement = elementAdapter.read(in);
                    validateJsonElement(jsonElement);
                    return thisAdapter.fromJsonTree(jsonElement);
                }
            }.nullSafe();
        }
    }

    /**
     * Create an instance of RunCount given an JSON string
     *
     * @param jsonString JSON string
     * @return An instance of RunCount
     * @throws IOException if the JSON string is invalid with respect to RunCount
     */
    public static RunCount fromJson(String jsonString) throws IOException {
        return JSON.getGson().fromJson(jsonString, RunCount.class);
    }

    /**
     * Convert an instance of RunCount to an JSON string
     *
     * @return JSON string
     */
    public String toJson() {
        return JSON.getGson().toJson(this);
    }
}

