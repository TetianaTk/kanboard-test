package ui.tests;

import api.apimethods.ProjectApi;
import api.models.CommonResp;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import java.util.UUID;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ui.dataprovider.UITestsDataProvider;
import ui.pageobjects.LoginPage;
import ui.pageobjects.ProjectBoard;
import ui.pageobjects.TaskOverviewSummary;

public class TaskActionsTest extends BasicUITest{

  private Integer userProjectId;
  private String userProjectName;
  private String userTaskName;

  @BeforeClass
  @Step("Setup test project with API function")
  public void setup() {
    super.setup();
    userProjectName = "Test Project : " + UUID.randomUUID();
    CommonResp createProjectResp = ProjectApi.createMyPrivateProject(getUsername(), getPassword(),
        userProjectName);
    userProjectId = (Integer) createProjectResp.getResult();
  }

  @Test(dataProviderClass = UITestsDataProvider .class, dataProvider = "generate task")
  @Description("Test task creation")
  public void createTaskTest(String taskName){
    SelenideElement taskTitle =
        new LoginPage()
        .login(getUsername(), getPassword())
        .getProjectBoard(userProjectId, userProjectName)
            .createNewTaskInBacklog(taskName)
            .getTaskBacklogListItem(taskName);
    taskTitle.shouldBe(Condition.visible);
    this.userTaskName = taskName;
  }

  @Test(dependsOnMethods = {"createTaskTest"},
      dataProviderClass = UITestsDataProvider .class, dataProvider = "generate task comment")
  @Description("Test task get commented")
  public void addTaskCommentTest(String taskComment){
    ElementsCollection taskComments = new ProjectBoard()
        .getTaskOverviewSummary(userTaskName)
        .addTaskComment(taskComment)
        .getComments();
    Assert.assertTrue(taskComments.stream().anyMatch(p -> p.getText().contains(taskComment)));
  }

  @Test(dependsOnMethods = {"addTaskCommentTest"})
  @Description("Test task get closed")
  public void closeTaskTest() {
    SelenideElement taskStatus = new TaskOverviewSummary()
        .closeTask()
        .getTaskStatusText();
    taskStatus.shouldBe(Condition.visible).shouldHave(Condition.text("closed"));
  }

  @AfterClass
  @Step("Cleanup test project with API function")
  public void cleanup() {
    ProjectApi.removeProject(getUsername(), getPassword(), userProjectId);
    super.cleanup();
  }

}
