package com.grupobancolombia.personas.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * Clase encargada de correr el test del feature especifico
 *
 * @author Andres Felipe Cardona
 */

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/ConsumerCreditSimulator.feature",
        glue = "com.grupobancolombia.personas.stepdefinitions",
        tags = " @TestConsumerCreditSimulator",
        snippets = SnippetType.CAMELCASE
)

public class ConsumerCreditSimulatorRunner {

}
