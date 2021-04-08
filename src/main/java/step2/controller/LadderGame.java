package step2.controller;

import step2.domain.Height;
import step2.domain.Lines;
import step2.domain.Persons;
import step2.view.InputView;
import step2.view.ResultView;

public class LadderGame {
    InputView inputView = new InputView();
    ResultView resultView = new ResultView();

    public void game() {
        String participants = inputView.inputParticipant();
        Persons persons = new Persons(participants);
        int height = inputView.inputHeight();

        Lines lines = Lines.lines(new Height(height), persons.personList().size());
        resultView.printPerson(persons);
        resultView.printLadder(lines);

    }
}
