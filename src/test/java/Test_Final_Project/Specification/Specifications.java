package Test_Final_Project.Specification;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specifications {
        public static RequestSpecification requestSpec(String url){
            return new RequestSpecBuilder()
                    .setBaseUri(url)
                    .setContentType(ContentType.JSON)
                    .build();
        }

        public static ResponseSpecification responseSpecOK200(){
            return new ResponseSpecBuilder()
                    .expectStatusCode(200)
                    .build();
        }
        public static ResponseSpecification responseSpecError400(){
            return new ResponseSpecBuilder()
                    .expectStatusCode(400)
                    .build();
        }
        public static ResponseSpecification responseSpecUnique(int status){
            return new ResponseSpecBuilder()
                    .expectStatusCode(status)
                    .build();
        }
}
