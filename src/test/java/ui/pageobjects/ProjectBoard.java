package ui.pageobjects;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

public class ProjectBoard extends BasicOverview{

  private final SelenideElement newTaskInBacklogItem = $x("//a[@title='Add a new task'][contains(@href, '/column/')]");
  private final SelenideElement newTaskNameInput = $("#form-title");
  private final SelenideElement newTaskSaveButton = $x("//button[@type='submit'][contains(text(),'Save')]");
  private final String taskBacklogListItem = "//a[text()='%s'][contains(@href, 'task')]";

  @Step("Creation of new task in backlog")
  public ProjectBoard createNewTaskInBacklog(String taskName) {
    getNewTaskInBacklogItem().click();
    getNewTaskNameInput().shouldBe(Condition.visible).setValue(taskName);
    getNewTaskSaveButton().shouldBe(Condition.visible).click();
    return this;
  }

  @Step("Switching to task overview page")
  public TaskOverviewSummary getTaskOverviewSummary(String taskName) {
    getTaskBacklogListItem(taskName).shouldBe(Condition.visible).click();
    return new TaskOverviewSummary();
  }

  public SelenideElement getNewTaskInBacklogItem() {
    return newTaskInBacklogItem;
  }

  public SelenideElement getNewTaskNameInput() {
    return newTaskNameInput;
  }

  public SelenideElement getNewTaskSaveButton() {
    return newTaskSaveButton;
  }

  public SelenideElement getTaskBacklogListItem(String taskName) {
    return $x(String.format(taskBacklogListItem, taskName));
  }
}
