package ui.pageobjects;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

public class DashboardOverview extends BasicOverview{

  private final SelenideElement newProjectMenuItem = $x("//div[@class='page-header']//a[@href='/project/create/personal']");
  private final SelenideElement newProjectNameInput = $("#form-name");
  private final SelenideElement newProjectSaveButton = $x("//button[@type='submit'][contains(text(),'Save')]");
  private final String projectListItem = "//a[@href='/board/%d'][text()='%s']";

  @Step("Creation of new project")
  public ProjectOverviewSummary createNewProject(String projectName) {
    getNewProjectMenuItem().shouldBe(Condition.visible).click();
    getNewProjectNameInput().shouldBe(Condition.visible).setValue(projectName);
    getNewProjectSaveButton().shouldBe(Condition.visible).click();
    return new ProjectOverviewSummary();
  }

  @Step("Switching to project board pages")
  public ProjectBoard getProjectBoard(Integer projectId, String projectName) {
    getProjectListItem(projectId, projectName).shouldBe(Condition.visible).click();
    return new ProjectBoard();
  }

  public SelenideElement getNewProjectMenuItem() {
    return newProjectMenuItem;
  }

  public SelenideElement getNewProjectNameInput() {
    return newProjectNameInput;
  }

  public SelenideElement getNewProjectSaveButton() {
    return newProjectSaveButton;
  }

  public SelenideElement getProjectListItem(Integer projectId, String projectName) {
    return $x(String.format(projectListItem,projectId, projectName));
  }
}
