package com.qa.utils;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class ScreenshotUtils {

    public static void tomarCaptura(String nombre) { //Cast que dice: Este driver puede comportarse cómo un trigger para hacer un screenshot

        TakesScreenshot screenshot=
                (TakesScreenshot) DriverManager.getDriver();

        //Declaración de que el archivo (File, se llama captura y dicha captura se obtiene cuando la acción del driver se ejecuta y se guarda cómo tipo Archivo)
        File captura = screenshot.getScreenshotAs(OutputType.FILE);

        String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

        Path destino = Path.of("evidencias",nombre + "_" + timestamp + ".png");

        try {
            Files.createDirectories(Path.of("evidencias"));
            Files.copy(captura.toPath(),destino);

            }
        //Aqui en el catch la letra e es el objeto que contiene la informacion del error
        catch (IOException e) {
            System.out.println("Error al guardar la captura: "+e.getMessage());
        }

    }
}
