package com.codespace.qa.marathon;

import com.codespace.qa.marathon.pages.ResultPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.codespace.qa.marathon.pages.HomePage;

public class SampleTestNgTest extends TestNgTestBase {

  private HomePage homepage;

  @BeforeMethod
  public void initPageObjects() {
    homepage = PageFactory.initElements(driver, HomePage.class);
  }

  @Test
  public void testSearch() {
    driver.get(baseUrl);

    Assert.assertTrue("".equals(homepage.header.getText()));

    homepage.searchField.sendKeys("QA marathon 2017" + Keys.ENTER);

    Assert.assertTrue(homepage.getResultPage().foundLinks
            .stream()
            .anyMatch(element -> element.getText()
                    .equals("Education QA Marathon autumn 2017 - Code Space")));
  }
}
