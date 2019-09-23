package com.grupobancolombia.personas.userinterfaces;


import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;


/**
 * Clase encargada de tener el mapeo de los elementos que usamos en la automatizacion de simular creditos de consumo
 * de la pagina portal personas
 *
 * @author Andres Felipe cardona
 */

@DefaultUrl("https://www.grupobancolombia.com/wps/portal/personas")
public class PeoplePortalPage extends PageObject {

    public static final Target SEARCH_OPTION = Target.the("Icon and option 'Search'")
            .located(By.className("icon_buscar"));

    public static final Target INPUT_SEARCH = Target.the("Input search term")
            .located(By.id("terminoBusqueda"));

    public static final Target SEARCH_ICON_INPUT= Target.the("Search Button on Input")
            .located(By.xpath("//input[contains(@data-ng-click,'ctrl.buscar(ctrl.patron)')]"));

    public static final Target SEARCH_RESULT= Target.the("List of Search Result")
            .located(By.xpath("//*[@id=\"main-content\"]/div[1]/div/div/div[2]/table[1]/tbody/tr[1]/td/a"));
}
