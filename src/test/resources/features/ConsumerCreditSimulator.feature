@TestConsumerCreditSimulator
Feature: validate credit simulation with fixed and variable rate and solicitation by dues

  @TestCase1
  Scenario Outline: Test Case 1 successful credit simulation
  Narrative:Do the credit simulation with fixed rate of the different products

    Given That user enters in website of the bancolombia people portal
    When He searches and chooses for the consumer credit simulator option
    And Choose the <SimulationType>, <BirthDate>, <RateType> and the credit <product> that want to purchase
    And Write the loan <term> and <value>
    And click on the simulate button
    Then the user validates the simulation information quota and <term> And the system save the relevant data in an excel

    Examples:
      |SimulationType |BirthDate |RateType |product                   |term|value  |
      |Simula tu Cuota|1993-06-09|Tasa Fija|Crédito de Libre Inversión|36  |2000000|
      |Simula tu Cuota|1993-06-09|Tasa Fija|Libranza Empleados        |50  |5000000|
      |Simula tu Cuota|1993-06-09|Tasa Fija|Libranza Protección       |48  |9000000|

  @TestCase2
  Scenario Outline: Test Case 2 successful credit simulation
  Narrative:Do the credit simulation with variable rate of the different products

    Given That user enters in website of the bancolombia people portal
    When He searches and chooses for the consumer credit simulator option
    And Choose the <SimulationType>, <BirthDate>, <RateType> and the credit <product> that want to purchase
    And Write the loan <term> and <value>
    And click on the simulate button
    Then the user validates the simulation information quota and <term> And the system save the relevant data in an excel

    Examples:
      |SimulationType |BirthDate |RateType     |product                   |term|value  |
      |Simula tu Cuota|1993-06-09|Tasa Variable|Crédito de Libre Inversión|42  |2000000|
      |Simula tu Cuota|1993-06-09|Tasa Variable|Crédito con Pignoración de Pensiones Voluntarias|36  |2000000|
      |Simula tu Cuota|1993-06-09|Tasa Variable|Libranza Empleados        |50  |5000000|
      |Simula tu Cuota|1993-06-09|Tasa Variable|Libranza FOPEP            |48  |9000000|

  @TestCase3
  Scenario Outline: Test Case 2 Failed credit simulation by incorrect data
  Narrative:Do the credit simulation with incorrect data in term field

    Given That user enters in website of the bancolombia people portal
    When He searches and chooses for the consumer credit simulator option
    And Choose the <SimulationType>, <BirthDate>, <RateType> and the credit <product> that want to purchase
    And Write the incorrect term <term>
    Then the user see an error message

    Examples:
      |SimulationType |BirthDate |RateType     |product                   |term|
      |Simula tu Cuota|1993-06-09|Tasa Fija    |Crédito de Libre Inversión|5   |

  @TestCase4
  Scenario Outline: Test Case 2 Failed credit simulation by incorrect data
  Narrative:Do the credit simulation with incorrect data in value field

    Given That user enters in website of the bancolombia people portal
    When He searches and chooses for the consumer credit simulator option
    And Choose the <SimulationType>, <BirthDate>, <RateType> and the credit <product> that want to purchase
    And Write the loan <term> and <value>
    Then the user sees an error message below the field

    Examples:
      |SimulationType |BirthDate |RateType     |product                   |term|value |
      |Simula tu Cuota|1993-06-09|Tasa Fija    |Crédito de Libre Inversión|40  |500000|


