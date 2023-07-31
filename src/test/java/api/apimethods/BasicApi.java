package api.apimethods;

import static environment.EnvVariables.*;

import io.restassured.RestAssured;
import java.util.Base64;
import api.models.BasicReq;

public class BasicApi {

  static {
    RestAssured.baseURI = API_BASE_URL;
  }

  private static String getXApiAuthValue(String username, String password) {
    return Base64.getEncoder().encodeToString(String.join(":",
        username, password).getBytes());
  }

  public static <T> T respondClassObject(String username, String password, Object bodyObject, Class<T> tClass) {
    return RestAssured.given()
        .header(API_AUTHENTICATION_HEADER, getXApiAuthValue(username, password))
        .body(bodyObject)
        .log().all()
        .post()
        .as(tClass);
  }

  public static <T extends BasicReq> T requestBodyObject(Class<T> tClass, String method, Long id, Object params) {
    T requestBody;
    try {
      requestBody = tClass.getDeclaredConstructor().newInstance();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    requestBody.setJsonrpc(JSONRPC);
    requestBody.setMethod(method);
    requestBody.setId(id);
    requestBody.setParams(params);
    return requestBody;
  }

}
