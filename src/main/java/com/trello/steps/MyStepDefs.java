package com.trello.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.junit.Cucumber;
import io.restassured.http.ContentType;
import org.junit.runner.RunWith;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import  static org.hamcrest.Matchers.*;


@RunWith(Cucumber.class)
public class MyStepDefs {
    @Given("i perform GET operation for endpoint {string}")
    public void iPerformGETOperationForEndpoint(String path) {

    }

    @Given("with path parameter board_id")
    public void with_path_parameter_board_id() {
        String response = with().queryParam("key", "8ac5e935b3a382274a6ccfdcc2db19a6").queryParam("token","ATTAf3d9b5c3e3ab4379fe3d58faeb2e8f480235a15e918864428ed1cd99a37ddc49FDEE0FEB").pathParam("board_id","647cf8b05e475180c5e560d2").log().all()
                .when().get("https://api.trello.com/1/boards/{board_id}")
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200)
                .extract()
                .asString();
        System.out.println(response);
    }

    @Then("I should see the board name as {string}")
    public void iShouldSeeTheBoardNameAs(String arg0) {
    }

    @Given("i perform POST operation for endpoint {string} with query parameter")
    public void i_perform_post_operation_for_endpoint_with_query_parameter(String endPoint, io.cucumber.datatable.DataTable dataTable) {

        Map<String, String> queryParameter =new HashMap<String, String>();
        queryParameter.put(dataTable.cell(1, 0), dataTable.cell(1, 1));
        given()
                .with()
                .queryParam("key", "8ac5e935b3a382274a6ccfdcc2db19a6").queryParam("token","ATTAf3d9b5c3e3ab4379fe3d58faeb2e8f480235a15e918864428ed1cd99a37ddc49FDEE0FEB")
                .contentType(ContentType.JSON)
                .queryParams(queryParameter)
                .log()
                .all()
                .when()
                .post("https://api.trello.com"+endPoint)
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200);
    }
}
