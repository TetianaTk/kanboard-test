package ui.pageobjects;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;

public class BasicOverview {

  private final SelenideElement dashboardTitle = $(".title");

  public SelenideElement getDashboardTitle() {
    return dashboardTitle;
  }

}
