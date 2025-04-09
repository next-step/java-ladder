package nextstep.ladder;

import nextstep.ladder.ui.InputView;

public class LadderGame {
    public static void main(String[] args) {
        String names = InputView.inputNames();
        String[] nameArray = StringParser.parse(names);
        Persons persons = new Persons(nameArray);
        int height = InputView.inputLadderHeight();
    }
}
