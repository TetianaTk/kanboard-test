package ui.pageobjects;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

public class TaskOverviewSummary extends BasicOverview{

  private final SelenideElement addTaskCommentDivItem = $x("//summary[text()='Comments']");
  private final SelenideElement addTaskCommentTextarea = $x(
      "//div[@class='text-editor-write-mode']//textarea[@name='comment']");
  private final SelenideElement saveButton = $x(
      "//div[@class='form-actions']/button[@type='submit'][contains(text(),'Save')]");
  private final ElementsCollection comments = $$x("//div[@class='markdown']/p");
  private final SelenideElement closeTaskSidebarItem = $x(
      "//a[contains(@href,'/close')][text()='Close this task'] ");
  private final SelenideElement modalConfirmButton = $("#modal-confirm-button");
  private final SelenideElement taskStatusText = $x("//li/strong[text()='Status:']/../span");

  @Step("Adding of the task comment")
  public TaskOverviewSummary addTaskComment(String taskComment) {
    getAddTaskCommentDivItem().shouldBe(Condition.visible).click();
    getAddTaskCommentTextarea().shouldBe(Condition.visible).setValue(taskComment);
    getSaveButton().shouldBe(Condition.visible).click();
    return this;
  }

  @Step("Closing of the task")
  public TaskOverviewSummary closeTask() {
    getCloseTaskSidebarItem().shouldBe(Condition.visible).click();
    getModalConfirmButton().shouldBe(Condition.visible).click();
    return this;
  }

  public SelenideElement getAddTaskCommentDivItem() {
    return addTaskCommentDivItem;
  }

  public SelenideElement getAddTaskCommentTextarea() {
    return addTaskCommentTextarea;
  }

  public SelenideElement getSaveButton() {
    return saveButton;
  }

  public ElementsCollection getComments() {
    return comments;
  }

  public SelenideElement getCloseTaskSidebarItem() {
    return closeTaskSidebarItem;
  }

  public SelenideElement getModalConfirmButton() {
    return modalConfirmButton;
  }

  public SelenideElement getTaskStatusText() {
    return taskStatusText;
  }
}
