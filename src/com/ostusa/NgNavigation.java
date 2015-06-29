package com.ostusa;

import java.net.URL;

import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriverException;

import com.sun.jndi.toolkit.url.Uri;

public class NgNavigation implements Navigation 
{
	private NgWebDriver NgDriver;
	private Navigation Nav;
	public Navigation WrappedNavigation;
	
	public NgNavigation(NgWebDriver ngDriver, Navigation navigation)
	{
		this.NgDriver = ngDriver;
		this.Nav = navigation;
		this.WrappedNavigation = this.Nav;
	}

	@Override
	public void back() {
		this.Nav.forward();
	}

	@Override
	public void forward() {
		this.Nav.forward();
	}

	@Override
	public void refresh() {
		this.Nav.refresh();
	}

	@Override
	public void to(String arg0) {
		if(arg0 == null)
		{
			throw new WebDriverException("URL cannot be null.");
		}
		
		this.NgDriver.navigate().to(arg0.toString());
	}

	@Override
	public void to(URL arg0) {
		this.NgDriver.navigate().to(arg0.toString());
		
	}
	
	
}
