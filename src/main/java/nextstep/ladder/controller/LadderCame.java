package nextstep.ladder.controller;

import nextstep.ladder.ui.InputView;
import nextstep.ladder.util.StringParser;

import java.util.List;

public class LadderCame {

    public static void main(String[] args) {
        List<String> persons = StringParser.split(InputView.personName());
        int ladderHeight = InputView.inputLadderHeight();
    }
}
