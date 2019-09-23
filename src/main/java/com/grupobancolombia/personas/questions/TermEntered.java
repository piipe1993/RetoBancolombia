package com.grupobancolombia.personas.questions;

import com.grupobancolombia.personas.userinterfaces.CreditSimulatorPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class TermEntered implements Question <String>  {


    @Override
    public String answeredBy(Actor actor) {
        String messageTermIncorrect =(Text.of(CreditSimulatorPage.MESSAGE_TERM_INCORRECT).viewedBy(actor).asString()
                .replace("mínimo","minimo"));
        System.out.println(messageTermIncorrect);
        return messageTermIncorrect;
    }
    public static TermEntered isIncorrect(){
        return new TermEntered();
    }
}
