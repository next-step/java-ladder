package nextstep.ladder.controller;

import nextstep.ladder.Height;
import nextstep.ladder.Ladder;
import nextstep.ladder.LadderRow;
import nextstep.ladder.Persons;
import nextstep.ladder.drawPolicy.RandomDraw;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class MainAction {

    public static void main(String args[]) {
        Persons persons = initPersons();
        Height ladderHeight = initHeight();

        ResultView.printResult(persons);

        List<LadderRow> ladderRowList = initLadderRows(persons, ladderHeight);
        Ladder ladder = new Ladder(ladderRowList);

        ResultView.printLadder(ladder.drawLadder());
    }

    private static Height initHeight() {
        InputView.printLadderHeightInput();
        return new Height(InputView.intInput());
    }

    private static Persons initPersons() {
        InputView.printPersonInput();
        return new Persons(InputView.stringInput()
                .split(","));
    }

    private static List<LadderRow> initLadderRows(Persons persons, Height ladderHeight) {
        List<LadderRow> ladderRowList = new ArrayList<>();

        for (int i = 0; i < ladderHeight.getHeight(); i++) {
            LadderRow ladderRow = new LadderRow(persons.personListSize(), new RandomDraw());
            ladderRowList.add(ladderRow);
        }
        return ladderRowList;
    }
}
