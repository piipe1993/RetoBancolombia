package com.grupobancolombia.personas.tasks;

import com.grupobancolombia.personas.userinterfaces.CreditSimulatorPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.actions.selectactions.SelectByIndexFromBy;
import net.serenitybdd.screenplay.actions.selectactions.SelectByValueFromElement;
import net.serenitybdd.screenplay.actions.selectactions.SelectByVisibleTextFromBy;
import net.serenitybdd.screenplay.actions.selectactions.SelectByVisibleTextFromTarget;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Objects;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class EnterInformation implements Task {

    private String simulationType, birthDate, rateType, product;
    private Object WebElement;


    public EnterInformation(String simulationType, String birthDate, String rateType, String product) {
        this.simulationType = simulationType;
        this.birthDate = birthDate;
        this.rateType = rateType;
        this.product = product;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        //WaitUntil.the(CreditSimulatorPage.SIMULATION_TYPE, isPresent()),
        //Click.on(CreditSimulatorPage.SIMULATION_TYPE),

        actor.attemptsTo(SelectFromOptions.byVisibleText(simulationType).from(CreditSimulatorPage.SIMULATION_TYPE),
                Enter.theValue(birthDate).into(CreditSimulatorPage.BIRTH_DATE),
               // Click.on(CreditSimulatorPage.NEXT_LABEL),
                SelectFromOptions.byVisibleText(rateType).from(CreditSimulatorPage.RATE_TYPE),
                Scroll.to(CreditSimulatorPage.PRODUCT_TYPE),
                SelectFromOptions.byVisibleText(product).from(CreditSimulatorPage.PRODUCT_TYPE)
        );

    }

    public static EnterInformation basicOfTheCredit(String simulationType, String birthDate, String rateType, String product) {
        return instrumented(EnterInformation.class, simulationType, birthDate, rateType, product);
    }

}
