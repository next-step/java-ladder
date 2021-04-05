package step2;

import step2.view.InputView;
import step2.view.ResultView;

import java.util.Arrays;
import java.util.List;

public class LadderGame {
    InputView inputView = new InputView();
    ResultView resultView = new ResultView();

    public void game() {
        String participants = inputView.inputParticipant();
        Persons persons = new Persons(participants);
        int height = inputView.inputHeight();

        Lines lines = Lines.Lines(new Height(height), persons.personList().size());
        resultView.printPerson(persons);
        resultView.printLadder(lines);

    }
}
