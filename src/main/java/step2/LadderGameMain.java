package step2;

import step2.domain.*;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.List;

public class LadderGameMain {
    public static void main(String[] args) {
        String personsString = InputView.inputPersons();
        int ladderHeight = InputView.inputHeight();

        Persons persons = Persons.of(personsString);
        Height height = Height.of(ladderHeight);
        Lines lines = Lines.createVertical(height, persons.count());
        List<Point> drewLines = lines.createHorizontal();

        ResultView.printLadder(persons, drewLines);
    }
}
