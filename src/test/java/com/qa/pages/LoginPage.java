package com.qa.pages;
import org.openqa.selenium.By;
import com.qa.utils.DriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.qa.utils.ConfigReader;


public class LoginPage {
    private By campoUsuario = By.id("user-name");
    private By campoContrasena = By.id("password");
    private By botonLogin = By.id("login-button");

    //Timer
    private WebDriverWait wait;

    //Constructor
    public LoginPage(){
        long timeout = Long.parseLong(ConfigReader.get("timeout"));

        wait = new WebDriverWait(
                DriverManager.getDriver(),
                Duration.ofSeconds(timeout)
        );

    }


    public void ingresarUsuario(String usuario) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(campoUsuario))
                .sendKeys(usuario);

    }

    public void ingresarContrasena(String contrasena){
        wait.until(ExpectedConditions.visibilityOfElementLocated(campoContrasena))
                .sendKeys(contrasena);
    }

    public void hacerClickLogin(){
        wait.until(ExpectedConditions.elementToBeClickable(botonLogin))
                .click();
    }
        private By mensajeError = By.cssSelector("[data-test='error']");
        public String obtenerMensajeError(){
            return wait.until(ExpectedConditions.visibilityOfElementLocated(mensajeError))
                    .getText();


        }

        private By logo = By.className("app_logo");
        public String obtenerLogo(){
            return wait.until(ExpectedConditions.visibilityOfElementLocated(logo))
                    .getText();
        }


        }


