package ladder.ui;

import ladder.Lines;

public class Client {

    public static void main(String[] args) {
        String nameOfPersons = InputUI.inputNameOfPersons();
        int ladderHeight = InputUI.inputLadderHeight();

        int countOfPerson = nameOfPersons.split(",").length;
        Lines lines = new Lines(ladderHeight, countOfPerson);

        OutputUI.printLadder(nameOfPersons, lines);
    }
}