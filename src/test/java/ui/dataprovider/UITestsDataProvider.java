package ui.dataprovider;

import java.util.UUID;
import org.testng.annotations.DataProvider;

public class UITestsDataProvider {

  @DataProvider(name = "generate illegal user")
  public Object[][] generateIllegalUser() {
    return new Object[][]{
        {"TestUser" + UUID.randomUUID(), "test!password"+UUID.randomUUID()},
        {"TestUser" + UUID.randomUUID(), "test!password"+UUID.randomUUID()}
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

  @DataProvider(name = "generate task comment")
  public Object[][] generateTaskComment() {
    return new Object[][]{
        {"Some comment : " + UUID.randomUUID()}
    };
  }



}
