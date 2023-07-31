package api.tests;

import static environment.EnvVariables.*;

import api.apimethods.TaskApi;
import api.apimethods.UserApi;
import environment.TempDatabaseUser;
import api.models.CommonResp;
import api.models.GetUserByResp;
import api.apimethods.ProjectApi;
import api.dataprovider.ApiTestsDataProvider;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RestApiTest {

  private Integer adminProjectId;
  private Integer adminTaskId;

  private String username;
  private String password;
  private Integer userId;
  private Integer userProjectId;
  private Integer userTaskId;


  @BeforeClass
  @Step("Setup of admin api token if needed")
  public void setup() {
    if (LOCAL_USAGE) TempDatabaseUser.SetTempAdminToken();
  }

  @AfterClass
  @Step("Cleanup of admin api token if needed")
  public void cleanup() {
    if (LOCAL_USAGE) TempDatabaseUser.ClearTempAdminToken();
  }

  @Test
  @Description("Test of admin account id")
  public void getAdminUserIdTest() {
    GetUserByResp user = UserApi.getUser(
        DATABASE_ADMIN_USER, DATABASE_ADMIN_TEMP_TOKEN, DATABASE_ADMIN_USER_ID);
    Assert.assertEquals(user.getResult().getId().intValue(), DATABASE_ADMIN_USER_ID);
  }

  @Test
  @Description("Test of admin name")
  public void getAdminUserNameTest() {
    GetUserByResp user = UserApi.getUserByName(DATABASE_ADMIN_USER, DATABASE_ADMIN_TEMP_TOKEN);
    Assert.assertEquals(user.getResult().getUsername(), DATABASE_ADMIN_USER);
  }

  @Test(dependsOnMethods = {"getAdminUserIdTest"},
      dataProviderClass = ApiTestsDataProvider.class, dataProvider = "generate project")
  @Description("Test of admin project creation")
  public void createAdminProjectTest(String projectName) {
    CommonResp createProjectResp = ProjectApi.createProject(DATABASE_ADMIN_USER,
        DATABASE_ADMIN_TEMP_TOKEN, projectName, DATABASE_ADMIN_USER_ID);
    adminProjectId = (Integer) createProjectResp.getResult();
    Assert.assertTrue(adminProjectId > 0);
  }

  @Test(dependsOnMethods = {"createAdminProjectTest", "removeAdminTaskTest"})
  @Description("Test of admin project removing")
  public void removeAdminProjectTest() {
    CommonResp removeProjectResp = ProjectApi.removeProject(DATABASE_ADMIN_USER,
        DATABASE_ADMIN_TEMP_TOKEN, adminProjectId);
    Assert.assertTrue((Boolean) removeProjectResp.getResult());
  }

  @Test(dependsOnMethods = {"createAdminProjectTest"},
      dataProviderClass = ApiTestsDataProvider.class, dataProvider = "generate task")
  @Description("Test of admin task creation")
  public void createAdminTaskTest(String taskTitle) {
    CommonResp createTaskResp = TaskApi.createTask(DATABASE_ADMIN_USER, DATABASE_ADMIN_TEMP_TOKEN,
        taskTitle, adminProjectId, DATABASE_ADMIN_USER_ID, DATABASE_ADMIN_USER_ID);
    adminTaskId = (Integer) createTaskResp.getResult();
    Assert.assertTrue(adminTaskId > 0);
  }

  @Test(dependsOnMethods = {"createAdminTaskTest"})
  @Description("Test of admin task removing")
  public void removeAdminTaskTest() {
    CommonResp removeTaskResp = TaskApi.removeTask(DATABASE_ADMIN_USER, DATABASE_ADMIN_TEMP_TOKEN,
        adminTaskId);
    Assert.assertTrue((Boolean) removeTaskResp.getResult());
  }

  @Test(dependsOnMethods = {"getAdminUserNameTest"},
      dataProviderClass = ApiTestsDataProvider.class, dataProvider = "generate user")
  @Description("Test of user creation")
  public void createUserTest(String username, String password) {
    CommonResp createUserResp = UserApi.createUser(DATABASE_ADMIN_USER, DATABASE_ADMIN_TEMP_TOKEN,
        username, password);
    userId = (Integer) createUserResp.getResult();
    Assert.assertTrue(userId > 0);
    createUserResp = UserApi.createUser( DATABASE_ADMIN_USER, DATABASE_ADMIN_TEMP_TOKEN, username, password);
    Assert.assertFalse((Boolean) createUserResp.getResult());
    this.username = username;
    this.password = password;
  }

  @Test(dependsOnMethods = {"createUserTest", "removeUserProjectTest"})
  @Description("Test of user removing")
  public void removeUserTest() {
    CommonResp removeUserResp = UserApi.removeUser(DATABASE_ADMIN_USER, DATABASE_ADMIN_TEMP_TOKEN,
        userId);
    Assert.assertTrue((Boolean) removeUserResp.getResult());
  }

  @Test(dependsOnMethods = {"createUserTest"},
      dataProviderClass = ApiTestsDataProvider.class, dataProvider = "generate project")
  @Description("Test of user project creation")
  public void createUserProjectTest(String projectName) {
    CommonResp createProjectResp = ProjectApi.createMyPrivateProject(username, password,
        projectName);
    userProjectId = (Integer) createProjectResp.getResult();
    Assert.assertTrue(userProjectId > 0);
  }

  @Test(dependsOnMethods = {"createUserProjectTest", "removeUserTaskTest"})
  @Description("Test of user project removing")
  public void removeUserProjectTest() {
    CommonResp removeProjectResp = ProjectApi.removeProject(username, password, userProjectId);
    Assert.assertTrue((Boolean) removeProjectResp.getResult());
  }

  @Test(dependsOnMethods = {"createUserProjectTest"},
      dataProviderClass = ApiTestsDataProvider.class, dataProvider = "generate task")
  @Description("Test of user task creation")
  public void createUserTaskTest(String taskTitle) {
    CommonResp createTaskResp = TaskApi.createTask(username, password, taskTitle, userProjectId,
        userId, userId);
    userTaskId = (Integer) createTaskResp.getResult();
    Assert.assertTrue(userTaskId > 0);
  }

  @Test(dependsOnMethods = {"createUserTaskTest"})
  @Description("Test of user task removing")
  public void removeUserTaskTest() {
    CommonResp removeTaskResp = TaskApi.removeTask(username, password, userTaskId);
    Assert.assertTrue((Boolean) removeTaskResp.getResult());
  }

}
