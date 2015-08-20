package com.ostusa;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.WrapsElement;

public class NgWebElement implements WebElement, WrapsElement
{

	private NgWebDriver ngDriver;
    private WebElement element;
    
    public NgWebElement(NgWebDriver ngDriver, WebElement element) 
    {
		this.ngDriver = ngDriver;
		this.element = element;
	}
    
	@Override
	public WebElement getWrappedElement() {
		return this.element;
	}

	@Override
	public void clear() {
		this.ngDriver.WaitForAngular();
		this.element.clear();
		
	}

	@Override
	public void click() {
		this.ngDriver.WaitForAngular();
        this.element.click();
	}

	@Override
	public NgWebElement findElement(By arg0) {
		if (arg0 instanceof JavaScriptBy)
        {
            ((JavaScriptBy)arg0).RootElement = this.element;
        }
		
		this.ngDriver.WaitForAngular();
        return new NgWebElement(this.ngDriver, this.element.findElement(arg0));
	}
	
	public List<NgWebElement> findNgElements(By arg0)
	{
		if (arg0 instanceof JavaScriptBy)
        {
            ((JavaScriptBy)arg0).RootElement = this.element;
        }
		List<WebElement> temp = this.element.findElements(arg0);
        this.ngDriver.WaitForAngular();
        List<NgWebElement> returnElements = new ArrayList<NgWebElement>();
        for(WebElement currrentEle : temp)
        {
        	returnElements.add((NgWebElement) currrentEle);
        }
        return returnElements;
	}

	@Override
	public List<WebElement> findElements(By arg0) {
		return null;
	}
	

	@Override
	public String getAttribute(String arg0) {
		this.ngDriver.WaitForAngular();
		return this.element.getAttribute(arg0);
	}

	@Override
	public String getCssValue(String arg0) {
		this.ngDriver.WaitForAngular();
		return this.element.getCssValue(arg0);
	}

	@Override
	public Point getLocation() {
		this.ngDriver.WaitForAngular();
        return this.element.getLocation();
	}

	@Override
	public Dimension getSize() {
		this.ngDriver.WaitForAngular();
        return this.element.getSize();
	}

	@Override
	public String getTagName() {
		this.ngDriver.WaitForAngular();
		return this.element.getTagName();
	}

	@Override
	public String getText() {
		this.ngDriver.WaitForAngular();
		return this.element.getText();
	}

	@Override
	public boolean isDisplayed() {
		this.ngDriver.WaitForAngular();
		return this.element.isDisplayed();
	}

	@Override
	public boolean isEnabled() {
		this.ngDriver.WaitForAngular();
		return this.element.isEnabled();
	}

	@Override
	public boolean isSelected() {
		this.ngDriver.WaitForAngular();
		return this.element.isSelected();
	}

	@Override
	public void sendKeys(CharSequence... arg0) {
		this.ngDriver.WaitForAngular();
		this.element.sendKeys(arg0);
		
	}

	@Override
	public void submit() {
		this.ngDriver.WaitForAngular();
		this.element.submit();
		
	}
	
}
