package com.ostusa;

import org.openqa.selenium.By;
//import com.ostusa.JavaScriptBy;

public class NgBy 
{
	private NgBy() { }
	
	public static By binding(String binding)
	{
		return new JavaScriptBy(ClientSideScripts.FindBindings, binding);
	}
	
	public static By model(String model)
	{
		return new JavaScriptBy(ClientSideScripts.FindModel, model);
	}
	
	public static By selectedOption(String model)
	{
		return new JavaScriptBy(ClientSideScripts.FindSelectedOptions, model);
	}
	
	public static By repeater(String repeat)
	{
		return new JavaScriptBy(ClientSideScripts.FindAllRepeaterRows, repeat);
	}
	
}
