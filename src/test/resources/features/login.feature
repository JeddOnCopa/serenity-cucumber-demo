@Login
Feature: Inicio de sesion

 @Smoke
 Scenario: Usuario inicia sesion correctamente
  Given que estoy en la pagina de login
  When ingreso el usuario "standard_user" y la contrasena "secret_sauce"
  And hago click en iniciar sesion
  Then deberia acceder al sistema

  @Regression
  Scenario Outline: Usuario intenta iniciar sesion con diferentes credenciales
   Given que estoy en la pagina de login
   When ingreso el usuario "<usuario>" y la contrasena "<contrasena>"
   And hago click en iniciar sesion
   Then deberia mostrarse el mensaje "<mensaje>"

   Examples:
   | usuario| contrasena| mensaje |
   | standard_user| wrong_password| Epic sadface: Username and password do not match any user in this service |

   | locked_out_user | secret_sauce|Epic sadface: Sorry, this user has been locked out.                       |
