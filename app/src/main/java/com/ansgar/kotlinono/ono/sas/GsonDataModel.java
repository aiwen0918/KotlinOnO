package com.ansgar.kotlinono.ono.sas;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

/**
 * Created by wcshao on 11/20/17.
 */

public class GsonDataModel {
    final static protected Gson sGson = ECGsonCreator.createGson();

    @Override
    public String toString() {
        return sGson.toJson(this);
    }

    public static <T extends GsonDataModel> T parse(String jsonString, Class<T> classOfT) {
        T jsonClass = null;
        if (TextUtils.isEmpty(jsonString)) {
            return jsonClass;
        }

        try {
            jsonClass = sGson.fromJson(jsonString, classOfT);
        } catch (JsonSyntaxException e) {
        }
        return jsonClass;
    }

    public static JsonObject toJsonObject(String jsonString) {
        try {
            JsonElement jsonElement = sGson.fromJson(jsonString, JsonElement.class);
            if (jsonElement == null) {
                return null;
            }
            return jsonElement.isJsonObject() ? jsonElement.getAsJsonObject() : null;
        } catch (Exception e) {
            return null;
        }
    }

    public static JsonObject getResults(String jsonStr) {
        try {
            JsonObject jsonObj = GsonDataModel.toJsonObject(jsonStr);
            if (jsonObj == null) {
                return null;
            }

            if (jsonObj.get("query") == null || !jsonObj.get("query").isJsonObject()) {
                return null;
            }
            JsonObject query = jsonObj.getAsJsonObject("query");

            //debug message
            parseDiagnostics(query);

            if (query.get("results") == null || !query.get("results").isJsonObject()) {
                return null;
            }
            JsonObject results = query.getAsJsonObject("results");

            return results;
        } catch (Exception e) {
            return null;
        }
    }

    public static JsonObject getResultsInResult(String jsonStr) {
        JsonObject innerResults = null;
        try {
            JsonObject results = getResults(jsonStr);

            if (results == null){
                return null;
            }

            JsonObject response = results.get("Response").getAsJsonObject();
            if (checkNull(response, "Response", false)) {
                return null;
            }

            innerResults = response.getAsJsonObject("Result");
        } catch (Exception e) {
        }

        return innerResults;
    }

    public static boolean checkNull(JsonElement js, String errorString, boolean showToast) {
        if (null == js) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkNull(JsonElement js, String errorString) {
        return checkNull(js, errorString, false);
    }

    private static void parseDiagnostics(JsonObject query) {
        if (query == null) {
            return;
        }

        try {
            JsonObject diagnostics = query.get("diagnostics").getAsJsonObject();
            if (diagnostics != null) {

            }
        } catch (IllegalStateException e) {
        } catch (NullPointerException e) {
        }
    }
}
