package com.ansgar.kotlinono.ono.sas;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

/**
 * Created by hryeh on 04/01/2018.
 */

public class ECGsonCreator {
    // 如果什麼都不寫，則沒有寫@Expose的field會被默認為serialize = true & deserialize = true，
    // 但是這時候在field上加@Expose(serialize = false)會沒有用，必須要在Gson Builder多call excludeFieldsWithoutExposeAnnotation()
    // 可是一但加上這個，沒有寫@Expose的field會被默認serialize = false & deserialize = false
    // 也就是parse的時候完全會跳過沒有寫@Expose的field，但是我們要serialize = false其實很少，所以乾脆自己寫skip的rule
    public static Gson createGson() {
        GsonBuilder builder = new GsonBuilder().addSerializationExclusionStrategy(new ExclusionStrategy() {
            @Override
            public boolean shouldSkipField(FieldAttributes fieldAttributes) {
                final Expose expose = fieldAttributes.getAnnotation(Expose.class);
                return expose != null && !expose.serialize();
            }

            @Override
            public boolean shouldSkipClass(Class<?> aClass) {
                return false;
            }
        }).addDeserializationExclusionStrategy(new ExclusionStrategy() {
            @Override
            public boolean shouldSkipField(FieldAttributes fieldAttributes) {
                final Expose expose = fieldAttributes.getAnnotation(Expose.class);
                return expose != null && !expose.deserialize();
            }

            @Override
            public boolean shouldSkipClass(Class<?> aClass) {
                return false;
            }
        });

        builder.setLenient();

        return builder.create();
    }
}
