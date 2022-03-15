package com.company;

import static com.company.UI.displayHeader;
import static com.company.ProgramManagement.mainProgram;
import static com.company.Utilities.loopProgram;

public class Main {

    public static void main(String[] args) {
        displayHeader();
        while(loopProgram) {
            mainProgram();
        }

    }
}
