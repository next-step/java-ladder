package step2;

import step2.domain.*;
import step2.view.InputView;
import step2.view.ResultView;

public class LadderGameMain {
    public static void main(String[] args) {
        String personsString = InputView.inputPersons();
        int ladderHeight = InputView.inputHeight();

        Persons persons = Persons.of(personsString);
        Height height = Height.of(ladderHeight);
        Ladder ladder = Ladder.create(height, persons.count());

        ResultView.print(persons, ladder);
    }
}
