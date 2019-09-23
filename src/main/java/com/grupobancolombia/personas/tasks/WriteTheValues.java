package com.grupobancolombia.personas.tasks;

import com.grupobancolombia.personas.userinterfaces.CreditSimulatorPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class WriteTheValues implements Task {

    private String term, value;

    public WriteTheValues (String term, String value){
        this.term = term;
        this.value = value;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
actor.attemptsTo(Scroll.to(CreditSimulatorPage.INPUT_TERM),
        Enter.theValue(term).into(CreditSimulatorPage.INPUT_TERM),
        Enter.theValue(value).into(CreditSimulatorPage.INPUT_VALUE)

);
    }

    public static WriteTheValues termAndValue (String term, String value){
        return instrumented(WriteTheValues.class,term,value);
    }

}
