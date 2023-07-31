package api.apimethods;

import api.models.CreateUserReq;
import api.models.CreateUserReqParams;
import api.models.CommonResp;
import api.models.UserByIdReq;
import api.models.GetUserByResp;
import api.models.UserByIdReqParams;
import api.models.UserByNameReq;
import api.models.UserByNameReqParams;
import io.qameta.allure.Step;

public class UserApi extends BasicApi {

  @Step("API create user")
  public static CommonResp createUser(String superUsername, String superPassword, String username, String password) {
    CreateUserReq createUserReq = requestBodyObject(CreateUserReq.class,
        "createUser", 1518863034L,
        new CreateUserReqParams().builder().username(username).password(password).build());
    return respondClassObject(superUsername, superPassword,createUserReq, CommonResp.class);
  }

  @Step("API remove user")
  public static CommonResp removeUser(String username, String password, Integer userId) {
    UserByIdReq removeUserReq = requestBodyObject(UserByIdReq.class,
        "removeUser", 2094191872L,
        new UserByIdReqParams(userId));
    return respondClassObject(username, password, removeUserReq, CommonResp.class);
  }

  @Step("API get user by id")
  public static GetUserByResp getUser(String username, String password, Integer userId) {
    UserByIdReq getUserByIdReq = requestBodyObject(UserByIdReq.class,
        "getUser", 1769674781L,
        new UserByIdReqParams(userId));
    return respondClassObject(username, password, getUserByIdReq, GetUserByResp.class);
  }

  @Step("API get user by name")
  public static GetUserByResp getUserByName(String username, String password) {
    UserByNameReq userByNameReq = requestBodyObject(UserByNameReq.class,
        "getUserByName", 1769674782L,
        new UserByNameReqParams(username));
    return respondClassObject(username, password, userByNameReq, GetUserByResp.class);
  }

}
