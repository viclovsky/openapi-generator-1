/*
 * OpenAPI Petstore
 * This spec is mainly for testing Petstore server and contains fake endpoints, models. Please do not use this for any other purpose. Special characters: \" \\
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.openapitools.client;

import org.openapitools.client.api.*;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.openapitools.client.Context;

public class ApiClient {

    private final Config config;

    private ApiClient(Config config) {
        this.config = config;
    }

    public static ApiClient api(Config config) {
        return new ApiClient(config);
    }

    public AnotherFakeApi anotherFake() {
        return AnotherFakeApi.anotherFake(config.baseReqSpec.get(), config.contextConsumer);
    }
    public FakeApi fake() {
        return FakeApi.fake(config.baseReqSpec.get(), config.contextConsumer);
    }
    public FakeClassnameTags123Api fakeClassnameTags123() {
        return FakeClassnameTags123Api.fakeClassnameTags123(config.baseReqSpec.get(), config.contextConsumer);
    }
    public PetApi pet() {
        return PetApi.pet(config.baseReqSpec.get(), config.contextConsumer);
    }
    public StoreApi store() {
        return StoreApi.store(config.baseReqSpec.get(), config.contextConsumer);
    }
    public UserApi user() {
        return UserApi.user(config.baseReqSpec.get(), config.contextConsumer);
    }

    public static class Config {
        private Supplier<RequestSpecBuilder> baseReqSpec;
        private Consumer<Context> contextConsumer = context -> {};

        /**
         * Use common specification for all operations
         * @param supplier supplier
         * @return configuration
         */
        public Config reqSpecSupplier(Supplier<RequestSpecBuilder> supplier) {
            this.baseReqSpec = supplier;
            return this;
        }

        /**
         * Use for handle context of operation
         * @param contextConsumer
         * @return configuration
         */
        public Config contextConsumer(Consumer<Context> contextConsumer) {
            this.contextConsumer = contextConsumer;
            return this;
        }

        public static Config apiConfig() {
            return new Config();
        }
    }
}