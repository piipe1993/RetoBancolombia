package com.grupobancolombia.personas.stepdefinitions;

import com.grupobancolombia.personas.interactions.ClickOn;
import com.grupobancolombia.personas.questions.QuotaResult;
import com.grupobancolombia.personas.questions.TermEntered;
import com.grupobancolombia.personas.questions.TermResult;
import com.grupobancolombia.personas.tasks.*;
import com.grupobancolombia.personas.userinterfaces.CreditSimulatorPage;
import com.grupobancolombia.personas.userinterfaces.PeoplePortalPage;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.matchers.statematchers.BaseWebElementStateMatcher;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class ConsumerCreditSimulatorStepDefinition {

    @Managed(driver = "chrome")
    private WebDriver webDriver;

    private Actor Andres = Actor.named("Andres");
    private PeoplePortalPage peoplePortalPage;

    @Before
    public void setup() {
        Andres.can(BrowseTheWeb.with(webDriver));
    }

    @Given("^That user enters in website of the bancolombia people portal$")
    public void that_user_enters_in_website_of_the_bancolombia_people_portal() {
        Andres.attemptsTo(OpenPeoplePortalWebsite.At(peoplePortalPage));
    }

    @When("^He searches and chooses for the consumer credit simulator option$")
    public void he_searches_and_chooses_for_the_consumer_credit_simulator_option() {
        Andres.attemptsTo(EnterCreditSimulator.option());
    }

    @And("^Choose the (.*), (.*), (.*) and the credit (.*) that want to purchase$")
    public void choose_the_and_the_credit_that_want_to_purchase(String simulationtype, String birthdate, String ratetype, String product) {
        Andres.attemptsTo(EnterInformation.basicOfTheCredit(simulationtype, birthdate, ratetype, product));
    }

    @And("^Write the loan (.*) and (.*)$")
    public void write_the_loan_and(String term, String value) {
        Andres.attemptsTo(WriteTheValues.termAndValue(term, value));
    }

    @And("^click on the simulate button$")
    public void click_on_the_simulate_button() throws InterruptedException {
        Andres.attemptsTo(ClickOn.SimulateButton());
        Thread.sleep(5000);
    }

    @Then("^the user validates the simulation information quota and (.*) And the system save the relevant data in an excel$")
    public void the_user_validates_the_simulation_information_quota_and_and_the_system_save_the_relevant_data_in_an_excel(String term)  {
        Andres.should(seeThat(QuotaResult.isNumber()));
        Andres.should(seeThat(TermResult.isCorrect(),equalTo(term+" meses")));
    }

    @And("^Write the incorrect term (.*)$")
    public void write_the_loan(String term)  {
        Andres.attemptsTo(EnterIncorrectNumber.inTerm(term));
    }

    @Then("^the user see an error message$")
    public void the_user_see_an_error_message()  {

        Andres.should(seeThat(WebElementQuestion.the(CreditSimulatorPage.MESSAGE_TERM_INCORRECT),
                WebElementStateMatchers.isVisible()));
        //Andres.should(seeThat(TermEntered.isIncorrect(), HasValue("36")));
    }


    @Then("^the user sees an error message below the field$")
    public void the_user_sees_an_error_message_below_the_field()  {
        Andres.should(seeThat(WebElementQuestion.the(CreditSimulatorPage.MESSAGE_VALUE_INCORRECT),
                WebElementStateMatchers.isVisible()));
    }

}
