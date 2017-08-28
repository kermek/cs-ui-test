package com.codespace.qa.marathon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Sample page
 */
public class HomePage extends Page {

  private ResultPage resultPage;

  @FindBy(how = How.TAG_NAME, using = "h1")
  @CacheLookup
  public WebElement header;

  @FindBy(how = How.ID, using = "lst-ib")
  public WebElement searchField;

  @FindBy(xpath = "//h3/a")
  private WebElement found;

  public HomePage(WebDriver webDriver) {
    super(webDriver);
  }

  public ResultPage getResultPage() {
    new WebDriverWait(driver, 60)
            .until(ExpectedConditions.visibilityOf(found));
    return PageFactory.initElements(driver, ResultPage.class);
  }
}
