package com.qa.steps;
import com.qa.utils.DriverManager;
import com.qa.utils.ScreenshotUtils;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.Scenario;
import com.qa.utils.ConfigReader;



public class Hooks {

@Before
public void iniciarNavegador() {
    String browser = ConfigReader.get("browser");

    if (browser.equalsIgnoreCase("chrome")){
        DriverManager.setDriver(new ChromeDriver());
    } else {
        throw new IllegalArgumentException("Navegador no soportado: "+browser);
    }

    DriverManager.getDriver()
            .get(ConfigReader.get("base.url"));


}

@After
public void cerrarNavegador(Scenario scenario){
    if (scenario.isFailed()){
        ScreenshotUtils.tomarCaptura(scenario.getName());
    }
    DriverManager.getDriver().quit();

}
}