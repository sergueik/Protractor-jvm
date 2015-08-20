package com.ostusa;

import org.openqa.selenium.By;
//import com.ostusa.JavaScriptBy;

public class NgBy 
{
	private NgBy() { }
	
	public static By Binding(String binding)
	{
		return new JavaScriptBy(ClientSideScripts.FindBindings, binding);
	}
	
	public static By Model(String model)
	{
		return new JavaScriptBy(ClientSideScripts.FindModel, model);
	}
	
	public static By SelectedOption(String model)
	{
		return new JavaScriptBy(ClientSideScripts.FindSelectedOptions, model);
	}
	
	public static By Repeater(String repeat)
	{
		return new JavaScriptBy(ClientSideScripts.FindAllRepeaterRows, repeat);
	}
	
}
