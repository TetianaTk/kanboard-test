package ui.pageobjects;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

public class LoginPage {

  private final SelenideElement userNameField = $("#form-username");
  private final SelenideElement passwordField = $("#form-password");
  private final SelenideElement loginButton = $("button[type='submit']");
  private final SelenideElement errorLable = $(".alert.alert-error");

  @Step("User login")
  public DashboardOverview login(String username, String password) {
    getUserNameField().shouldBe(Condition.visible).setValue(username);
    getPasswordField().shouldBe(Condition.visible).setValue(password);
    getLoginButton().shouldBe(Condition.visible).click();
    return new DashboardOverview();
  }

  @Step("User login fail")
  public LoginPage loginError(String username, String password) {
    getUserNameField().shouldBe(Condition.visible).setValue(username);
    getPasswordField().shouldBe(Condition.visible).setValue(password);
    getLoginButton().shouldBe(Condition.visible).click();
    return this;
  }

  public SelenideElement getUserNameField() {
    return userNameField;
  }

  public SelenideElement getPasswordField() {
    return passwordField;
  }

  public SelenideElement getLoginButton() {
    return loginButton;
  }

  public SelenideElement getErrorLable() {
    return errorLable;
  }
}
