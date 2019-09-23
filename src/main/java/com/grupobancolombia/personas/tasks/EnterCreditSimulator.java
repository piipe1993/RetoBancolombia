package com.grupobancolombia.personas.tasks;

import com.grupobancolombia.personas.userinterfaces.PeoplePortalPage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SendKeysIntoTarget;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.WebElement;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class EnterCreditSimulator implements Task {


    private String SearchWord = "Simulador de credito";

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(PeoplePortalPage.SEARCH_OPTION), Enter.theValue(SearchWord).into(PeoplePortalPage.INPUT_SEARCH),
                Click.on(PeoplePortalPage.SEARCH_ICON_INPUT),
                WaitUntil.the(PeoplePortalPage.SEARCH_RESULT,isPresent()),
                Click.on(PeoplePortalPage.SEARCH_RESULT)


        );
/*
        String correctResult = "Simulador Crédito de Consumo";
        List<WebElementFacade> lstSearchResults = PeoplePortalPage.SEARCH_RESULT.resolveAllFor(actor);
        for (WebElement allResults : lstSearchResults){
            if (correctResult.equalsIgnoreCase(allResults.getText())){
                allResults.click();
                break;
            }
        } */
    }

    public static EnterCreditSimulator option (){
        return instrumented(EnterCreditSimulator.class);
    }

}
