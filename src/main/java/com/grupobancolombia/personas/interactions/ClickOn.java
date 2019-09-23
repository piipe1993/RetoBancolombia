package com.grupobancolombia.personas.interactions;

import com.grupobancolombia.personas.userinterfaces.CreditSimulatorPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ClickOn implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(CreditSimulatorPage.SIMULATE_BUTTON));
    }

    public static ClickOn SimulateButton(){
        return instrumented(ClickOn.class);
    }
}
