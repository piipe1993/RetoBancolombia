package com.grupobancolombia.personas.questions;

import com.grupobancolombia.personas.tasks.SaveValues;
import com.grupobancolombia.personas.userinterfaces.CreditSimulatorPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import org.apache.commons.lang3.math.NumberUtils;

public class QuotaResult implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        String quotaresult = Text.of(CreditSimulatorPage.MONTHLY_FEE_RESULT).viewedBy(actor).asString().replace("$", "")
                .replace(",", "");
       //actor.attemptsTo(SaveValues.inExcel( 0,0,quotaresult));
        return NumberUtils.isCreatable(quotaresult);
    }

    public static QuotaResult isNumber() {
        return new QuotaResult();
    }
}
