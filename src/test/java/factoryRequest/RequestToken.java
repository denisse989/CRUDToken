package factoryRequest;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RequestToken implements IRequest {
    @Override
    public Response send(RequestInformation requestInformation, String token) {

        Response response= given()
                .auth()
                .preemptive()
                .basic("upb_api@api.com","12345")
                .log().all()
                .when()
                .get(requestInformation.getUrl());

        response.then().log().all();
        return response;
    }
}
