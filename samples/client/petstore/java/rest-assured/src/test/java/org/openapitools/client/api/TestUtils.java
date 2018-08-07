package org.openapitools.client.api;

import io.restassured.builder.RequestSpecBuilder;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;

import static io.restassured.http.ContentType.JSON;

public class TestUtils {
    private static final AtomicLong atomicId = createAtomicId();

    public static long nextId() {
        return atomicId.getAndIncrement();
    }

    private static AtomicLong createAtomicId() {
        int baseId = new Random(System.currentTimeMillis()).nextInt(1000000) + 20000;
        return new AtomicLong((long) baseId);
    }

    public static Consumer<RequestSpecBuilder> contentTypeJson() {
        return r -> r.setContentType(JSON);
    }
}

