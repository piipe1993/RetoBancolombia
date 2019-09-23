package com.grupobancolombia.personas.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 * Clase encargada de tener el mapeo de los elementos que usamos en la automatizacion de simular creditos de consumo
 * de la pagina del simulador
 */

public class CreditSimulatorPage {

    public static final Target SIMULATION_TYPE = Target.the("ComboBox simulation type")
            .located(By.name("comboTipoSimulacion"));

    public static final Target BIRTH_DATE = Target.the("date of birth")
            .located(By.name("dateFechaNacimiento"));

    public static final Target NEXT_LABEL = Target.the("Next label")
            .located(By.xpath("//label[contains(.,'¿Con qué tipo de tasa quieres tu préstamo?')]"));

    public static final Target RATE_TYPE = Target.the("ComboBox rate type")
            .located(By.name("comboTipoTasa"));

    public static final Target PRODUCT_TYPE = Target.the("ComboBox product type")
            .located(By.name("comboTipoProducto"));

    public static final Target INPUT_TERM = Target.the("Input investment term")
            .located(By.name("textPlazoInversion"));

    public static final Target INPUT_VALUE = Target.the("Input loan value")
            .located(By.name("textValorPrestamo"));

    public static final Target SIMULATE_BUTTON = Target.the("button simulate credit")
            .located(By.xpath("//button[contains(.,'Simular')]"));

    public static final Target SIMULATION_RESULTS = Target.the("list of credit simulation results")
            .located(By.className("table-datos"));

    public static final Target MONTHLY_FEE_RESULT = Target.the("Monthly fee Value")
            .located(By.xpath("(//td[@class='monto valor ng-binding'])[6]"));

    public static final Target TERM_RESULT = Target.the("Term Value in the results")
            .located(By.xpath("(//td[@class='monto valor ng-binding'])[7]"));

    public static final Target MESSAGE_TERM_INCORRECT = Target.the("Message to enter incorrect term")
            .located(By.xpath("//*[@id=\"sim-detail\"]/form/div[7]/div[1]/div/div/span[3]"));

    public static final Target MESSAGE_VALUE_INCORRECT = Target.the("Message to enter incorrect term")
            .located(By.xpath("//*[@id=\"sim-detail\"]/form/div[7]/div[2]/div/div/span[3]"));
}
