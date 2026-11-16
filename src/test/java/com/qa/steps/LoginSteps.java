package com.qa.steps;

import com.qa.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.junit.jupiter.api.Assertions;
import com.qa.utils.DriverManager;

public class LoginSteps {
    private LoginPage loginPage = new LoginPage();

    @Given("que estoy en la pagina de login")
    public void estoyEnLaPaginaDeLogin() {
        System.out.println("Estoy en la pagina de login");
    }

    @When("ingreso el usuario {string} y la contrasena {string}")
    public void ingresoUsuarioYContrasena(String usuario, String contrasena) {
        loginPage.ingresarUsuario(usuario);
        loginPage.ingresarContrasena(contrasena);

        System.out.println("Usuario y contraseña ingresados");
    }

    @And("hago click en iniciar sesion")
    public void hagoClickEnIniciarSesion() {
        loginPage.hacerClickLogin();
    }

    @Then("deberia mostrarse el mensaje {string}")
    public void deberiaMostrarseElMensaje(String mensajeEsperado) {
        String mensajeActual = loginPage.obtenerMensajeError();

        Assertions.assertEquals(
                mensajeEsperado,
                mensajeActual
        );
    }

    @Then("deberia acceder al sistema")
    public void deberiaAccederAlSistema() {
        String logoActual = loginPage.obtenerLogo();


        Assertions.assertEquals(
                "Swag Labs",
                logoActual
        );
    }
}