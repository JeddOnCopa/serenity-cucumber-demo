package com.qa.utils;
import org.openqa.selenium.WebDriver;
public class DriverManager {
    private static WebDriver driver;

    public static void setDriver(WebDriver nuevoDriver){
        driver= nuevoDriver;
    }

 public static WebDriver getDriver(){
        return driver;

 }
}