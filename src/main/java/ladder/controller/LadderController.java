package ladder.controller;

import ladder.domain.Persons;
import ladder.view.InputView;

public class LadderController {
    private InputView inputView = new InputView();

    public void run() {
        Persons persons = Persons.from(inputView.inputPersonNames());
        System.out.println(persons.toString());
    }
}
