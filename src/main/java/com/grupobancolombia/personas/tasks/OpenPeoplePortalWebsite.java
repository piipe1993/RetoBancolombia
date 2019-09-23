package com.grupobancolombia.personas.tasks;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 * Clase encargada de abrir el navegador e ingresar al portal personas de bancolombia
 *
 * @author Andres
 */

public class OpenPeoplePortalWebsite implements Task {

    private PageObject pageObject;

    public OpenPeoplePortalWebsite(PageObject pageObject) {
        this.pageObject = pageObject;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn(pageObject));
    }

    public static OpenPeoplePortalWebsite At (PageObject pageobject) {
        return instrumented(OpenPeoplePortalWebsite.class, pageobject);
    }
}
