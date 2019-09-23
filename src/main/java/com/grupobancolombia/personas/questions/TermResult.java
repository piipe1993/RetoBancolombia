package com.grupobancolombia.personas.questions;

import com.grupobancolombia.personas.tasks.SaveValues;
import com.grupobancolombia.personas.userinterfaces.CreditSimulatorPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class TermResult implements Question <String> {

    @Override
    public String answeredBy(Actor actor) {
        //String termresult = CreditSimulatorPage.TERM_RESULT.resolveFor(actor).getText();
        String termresult =(Text.of(CreditSimulatorPage.TERM_RESULT).viewedBy(actor).asString());
        System.out.println(termresult);
      // actor.attemptsTo(SaveValues.inExcel(0, 1,termresult));
        return termresult;
    }
    public static TermResult isCorrect(){
        return new TermResult();
    }
}
