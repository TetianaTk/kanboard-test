package api.apimethods;

import api.models.CommonResp;
import api.models.CreatePrivateProjectReq;
import api.models.GetProjectByNameReq;
import api.models.GetProjectByNameReqParams;
import api.models.GetProjectByNameResp;
import io.qameta.allure.Step;
import java.util.Arrays;
import java.util.List;
import api.models.AddProjectUserReq;
import api.models.CreateProjectReq;
import api.models.CreateProjectReqParams;
import api.models.ProjectByIdReq;
import api.models.ProjectByIdReqParams;

public class ProjectApi extends BasicApi {

  @Step("API Create project")
  public static CommonResp createProject(String username, String password, String name, Integer ownerId) {
    CreateProjectReq projectReq = requestBodyObject(CreateProjectReq.class,
        "createProject", 1797076613L, new CreateProjectReqParams(name, ownerId));
    return respondClassObject(username, password, projectReq, CommonResp.class);
  }

  @Step("API remove project")
  public static CommonResp removeProject(String username, String password, Integer projectId) {
    ProjectByIdReq projectReq = requestBodyObject(ProjectByIdReq.class,
        "removeProject", 46285125L, new ProjectByIdReqParams(projectId));
    return respondClassObject(username, password, projectReq, CommonResp.class);
  }

  @Step("API add project user")
  public static CommonResp addProjectUser(String username, String password, Integer projectId, Integer userId, String role) {
    List<String> paramsList = Arrays.asList(Integer.toString(projectId), Integer.toString(userId),
        role);
    AddProjectUserReq projectReq = requestBodyObject(AddProjectUserReq.class,
        "addProjectUser", 1294688355L, paramsList);
    return respondClassObject(username, password, projectReq, CommonResp.class);
  }

  @Step("API Create private project")
  public static CommonResp createMyPrivateProject(String username, String password, String name) {
    CreatePrivateProjectReq projectReq = requestBodyObject(CreatePrivateProjectReq.class,
        "createMyPrivateProject", 1271580569L, Arrays.asList(name));
    return respondClassObject(username, password, projectReq, CommonResp.class);
  }

  @Step("API get project by name")
  public static GetProjectByNameResp getProjectByName(String username, String password, String name) {
    GetProjectByNameReq projectReq = requestBodyObject(GetProjectByNameReq.class,
        "getProjectByName", 1620253806L, new GetProjectByNameReqParams(name));
    return respondClassObject(username, password, projectReq, GetProjectByNameResp.class);
  }


}
