package com.grupobancolombia.personas.tasks;

import com.grupobancolombia.personas.userinterfaces.CreditSimulatorPage;
import com.grupobancolombia.personas.utils.Excel;
import com.grupobancolombia.personas.utils.WriteExcelFile;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.questions.Text;

import java.io.IOException;


public class SaveValues implements Task {

    private Excel excel;
    String pathFile = "SimulationResults.xlsx";

    private String valueSave;
    private int columnIndex;
    private int rowNumber;

    public SaveValues(int rowNumber, int columnIndex, String valueSave) {
        this.valueSave = valueSave;
        this.columnIndex = columnIndex;
        this.rowNumber = rowNumber;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        excel.write(pathFile, "Results", rowNumber, columnIndex, valueSave);

    }

    public static SaveValues inExcel(int rowNumber, int columnIndex, String valueSave) {
        return new SaveValues(rowNumber, columnIndex, valueSave);
    }
}
