package spec;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static filter.LogFilter.filters;

public class Request {

    private static final RequestSpecification SPEC = new RequestSpecBuilder()
            .setBaseUri("https://shop.vsk.ru/api/v1/")
            .addFilter(filters().withCustomTemplates())
            .setAccept("application/json")
            .log(LogDetail.ALL)
            .build();

    public static RequestSpecification spec(){
        return SPEC;
    }
}