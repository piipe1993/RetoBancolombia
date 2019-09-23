package com.grupobancolombia.personas.tasks;

import com.grupobancolombia.personas.userinterfaces.CreditSimulatorPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EnterIncorrectNumber implements Task {
    private String term;

    public EnterIncorrectNumber(String term){
        this.term = term;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Scroll.to(CreditSimulatorPage.INPUT_TERM),
                Enter.theValue(term).into(CreditSimulatorPage.INPUT_TERM));
    }
    public static EnterIncorrectNumber inTerm (String term){
        return instrumented(EnterIncorrectNumber.class,term);
    }
}
