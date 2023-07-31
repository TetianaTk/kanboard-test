package ui.tests;

import static environment.EnvVariables.*;

import api.apimethods.UserApi;
import api.models.CommonResp;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import environment.TempDatabaseUser;
import io.qameta.allure.Step;
import java.util.UUID;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BasicUITest {

  private String username;
  private String password;
  private Integer userId;

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public Integer getUserId() {
    return userId;
  }

  @BeforeClass
  @Step("Setup test user with API function")
  public void setup() {
    if (LOCAL_USAGE) TempDatabaseUser.SetTempAdminToken();
    this.username = "TestUser" + UUID.randomUUID();
    this.password = "test!password";
    CommonResp createUserResp = UserApi.createUser(DATABASE_ADMIN_USER, DATABASE_ADMIN_TEMP_TOKEN,
        username, password);
    this.userId = (Integer) createUserResp.getResult();
    Configuration.browser = BROWSER_NAME;
    Configuration.headless =  BROWSER_HEADLESS;
    Selenide.open(UI_BASE_URL);
  }

  @AfterClass
  @Step("Cleanup test user with API function")
  public void cleanup() {
    Selenide.closeWindow();
    Selenide.closeWebDriver();
    UserApi.removeUser(DATABASE_ADMIN_USER, DATABASE_ADMIN_TEMP_TOKEN,
        userId); // in case of user removed all user projects cascaded removed as well
    if (LOCAL_USAGE) TempDatabaseUser.ClearTempAdminToken();
  }

}
