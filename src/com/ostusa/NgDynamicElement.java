package com.ostusa;

import java.util.List;

import org.openqa.selenium.*;

public class NgDynamicElement implements WebElement
{
	public String Binding;
	public String Model;
	public String SelectedOption;
	public String Repeater;
	
	private NgWebDriver Driver;
	private WebElement rootElement;
	
	public NgDynamicElement() { }
	
	public NgDynamicElement(NgWebDriver driver)
	{
		Driver = driver;
	}
	
	public NgDynamicElement SetBinding(String binding)
	{
		Binding = binding;
		return this;
	}
	
	public NgDynamicElement SetModel(String model)
	{
		Model = model;
		return this;
	}
	
	public NgDynamicElement SetSelectedOption(String option)
	{
		SelectedOption = option;
		return this;
	}
	
	public NgDynamicElement SeRepeater(String repeater)
	{
		Repeater = repeater;
		return this;
	}
	
	private NgDynamicElement Find()
	{
		rootElement = null;
		
		if(Binding != null)
		{
			rootElement = Driver.findElement(NgBy.binding(Binding));
		}
		
		if (Model != null)
		{
			rootElement = Driver.findElement(NgBy.model(Model));
		}
		
		if (SelectedOption != null)
		{
			rootElement = Driver.findElement(NgBy.selectedOption(SelectedOption));
		}
		
		if (Repeater != null)
		{
			rootElement = Driver.findElement(NgBy.repeater(Repeater));
		}
		
		if(rootElement != null)
		{
			return this;
		}
		
		return null;
	}
	
	public NgDynamicElement SetDriver(NgWebDriver driver)
	{
		this.Driver = driver;
		return this;
	}
	
	@Override
	public void clear() 
	{
		this.Driver.WaitForAngular();
		this.Find();
		this.rootElement.clear();
	}
	@Override
	public void click() {
		this.Driver.WaitForAngular();
		this.Find();
		this.rootElement.click();
		
	}
	
	@Override
	public WebElement findElement(By arg0) {
		throw new WebDriverException("findElement can not be used with this element type");
	}
	
	@Override
	public List<WebElement> findElements(By arg0) {
		throw new WebDriverException("findElements can not be used with this element type");
	}
	
	@Override
	public String getAttribute(String arg0) {
		this.Driver.WaitForAngular();
		this.Find();
		return this.rootElement.getAttribute(arg0);
	}
	
	@Override
	public String getCssValue(String arg0) {
		this.Driver.WaitForAngular();
		this.Find();
		return this.rootElement.getCssValue(arg0);
	}
	
	@Override
	public Point getLocation() {
		this.Driver.WaitForAngular();
		this.Find();
		return this.rootElement.getLocation();
	}
	
	@Override
	public Dimension getSize() {
		this.Driver.WaitForAngular();
		this.Find();
		return this.rootElement.getSize();
	}
	
	@Override
	public String getTagName() {
		this.Driver.WaitForAngular();
		this.Find();
		return this.rootElement.getTagName();
	}
	
	@Override
	public String getText() {
		this.Driver.WaitForAngular();
		this.Find();
		return this.rootElement.getText();
	}
	
	@Override
	public boolean isDisplayed() {
		this.Driver.WaitForAngular();
		this.Find();
		return this.rootElement.isDisplayed();
	}
	
	@Override
	public boolean isEnabled() {
		this.Driver.WaitForAngular();
		this.Find();
		return this.rootElement.isEnabled();
	}
	
	@Override
	public boolean isSelected() {
		this.Driver.WaitForAngular();
		this.Find();
		return this.rootElement.isSelected();
	}
	
	@Override
	public void sendKeys(CharSequence... arg0) {
		this.Driver.WaitForAngular();
		this.Find();
		this.rootElement.sendKeys(arg0);
	}
	
	@Override
	public void submit() {
		this.Driver.WaitForAngular();
		this.Find();
		this.rootElement.submit();
	}


	@Override
	public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
		return rootElement.getScreenshotAs(target);
	}
}
