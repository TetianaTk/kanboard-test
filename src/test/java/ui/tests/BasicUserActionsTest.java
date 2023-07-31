package ui.tests;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import ui.dataprovider.UITestsDataProvider;
import ui.pageobjects.DashboardOverview;
import ui.pageobjects.LoginPage;

public class BasicUserActionsTest extends BasicUITest{

  @Test(dependsOnMethods = "loginErrorTest")
  @Description("Test user successfully login")
  public void loginSuccessfulTest(){
    SelenideElement dashboardTitle = new LoginPage()
        .login(getUsername(), getPassword())
        .getDashboardTitle();
    dashboardTitle.shouldBe(Condition.visible).shouldHave(Condition.text("Dashboard for " + getUsername()));
  }

  @Test(dataProviderClass = UITestsDataProvider.class, dataProvider = "generate illegal user")
  @Description("Test user login fail")
  public void loginErrorTest(String username, String password){
    SelenideElement errorLable = new LoginPage()
        .loginError(username, password)
        .getErrorLable();
    errorLable.shouldBe(Condition.visible).shouldHave(Condition.text("Bad username or password"));
  }

  @Test(dependsOnMethods = "loginSuccessfulTest",
      dataProviderClass = UITestsDataProvider.class, dataProvider = "generate project")
  @Description("Test user project creation")
  public void createNewProjectTest(String projectName){
    SelenideElement projectTitle = new DashboardOverview()
        .createNewProject(projectName)
        .getDashboardTitle();
    projectTitle.shouldBe(Condition.visible).shouldHave(Condition.text(projectName));
  }

}

