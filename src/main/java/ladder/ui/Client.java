package ladder.ui;

import ladder.Lines;

public class Client {

    public static void main(String[] args) {
        String nameOfParticipants = InputUI.inputnameOfParticipants();
        int ladderHeight = InputUI.inputLadderHeight();

        int numberOfParticipant = nameOfParticipants.split(",").length;
        Lines lines = new Lines(ladderHeight, numberOfParticipant);

        OutputUI.printLadder(nameOfParticipants, lines);
    }
}