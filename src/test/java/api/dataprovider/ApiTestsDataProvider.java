package api.dataprovider;

import java.util.UUID;
import org.testng.annotations.DataProvider;

public class ApiTestsDataProvider {

  @DataProvider(name = "generate user")
  public Object[][] generateUser() {
    return new Object[][]{
        {"TestUser" + UUID.randomUUID(), "test!password"}
    };
  }

  @DataProvider(name = "generate project")
  public Object[][] generateProject() {
    return new Object[][]{
        {"Test Project : " + UUID.randomUUID()}
    };
  }

  @DataProvider(name = "generate task")
  public Object[][] generateTask() {
    return new Object[][]{
        {"Test Task : " + UUID.randomUUID()}
    };
  }

}
