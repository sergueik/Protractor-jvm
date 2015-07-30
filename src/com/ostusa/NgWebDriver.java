package com.ostusa;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.WrapsDriver;
import org.openqa.selenium.JavascriptExecutor;

public class NgWebDriver implements WebDriver, WrapsDriver
{
	private String AngularDeferBootstrap = "NG_DEFER_BOOTSTRAP!";
	
	private WebDriver driver;
	private JavascriptExecutor jsExecutor;
	private String rootElement;
	private NgModule[] mockModules;
	public boolean IgnoreSynchronization;

	public NgWebDriver(WebDriver driver)
	{
		this.driver = driver;
		this.jsExecutor = (JavascriptExecutor)driver;
		this.rootElement = "body";
	}

	public NgWebDriver(WebDriver driver, NgModule[] mockModules)
	{
		this(driver, "body", mockModules);
	}
	
	public NgWebDriver(WebDriver driver, String rootElement ,NgModule[] mockModules)
	{
		if(!(driver instanceof JavascriptExecutor))
		{
			throw new WebDriverException("The WebDriver instance must implement the JavaScriptExecutor interface.");
		}
		
		this.driver = driver;
		this.jsExecutor = (JavascriptExecutor)driver;
		this.rootElement = rootElement;
		this.mockModules = mockModules;
	}
	
	
	public String getRootElement()
	{
		return this.rootElement;
	}

	@Override
	public WebDriver getWrappedDriver() {
		return this.driver;
	}

	@Override
	public void close() {
		this.driver.close();
		
	}

	public NgWebElement findElement(By arg0)
	{
		this.WaitForAngular();
		return new NgWebElement(this, this.driver.findElement(arg0));
	}
	
	/*@Override
	public WebElement findElement(By arg0) {
		this.WaitForAngular();
		return new NgWebElement(this, this.driver.findElement(arg0));
	}*/
	
	public List<NgWebElement> findNGElements(By arg0)
	{
		this.WaitForAngular();
        List<WebElement> temp = this.driver.findElements(arg0);
        // not sure idf this is correct
        List<NgWebElement> returnElements = new ArrayList<NgWebElement>();
        for(WebElement currrentEle : temp)
        {
        	returnElements.add((NgWebElement) currrentEle);
        }
        return returnElements;
	}

	@Override
	public List<WebElement> findElements(By arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void get(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getCurrentUrl() {
		this.WaitForAngular();
		return this.driver.getCurrentUrl();
	}

	@Override
	public String getPageSource() {
		this.WaitForAngular();
		return this.driver.getPageSource();
	}

	@Override
	public String getTitle() {
		this.WaitForAngular();
		return driver.getTitle();
	}

	@Override
	public String getWindowHandle() {
		this.WaitForAngular();
		return driver.getWindowHandle();
	}

	@Override
	public Set<String> getWindowHandles() {
		this.WaitForAngular();
		return driver.getWindowHandles();
	}

	@Override
	public Options manage() {
		//this.WaitForAngular();
		return this.driver.manage();
	}

	@Override
	public Navigation navigate() {
		return new NgNavigation(this, this.driver.navigate());
	}

	@Override
	public void quit() {
		this.driver.quit();
		
	}

	@Override
	public TargetLocator switchTo() {
		return this.driver.switchTo();
	}
	
	public void WaitForAngular()
    {
        if (!this.IgnoreSynchronization)
        {
            this.jsExecutor.executeAsyncScript(ClientSideScripts.WaitForAngular, this.rootElement);
        }
    }
	
}
