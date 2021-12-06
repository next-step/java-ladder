package nextstep.ladder.controller;

import nextstep.ladder.domain.Lines;
import nextstep.ladder.view.OutPut;

public class LadderController {
    public static void main(String[] args) {
        Lines lines = Lines.of(5,5);
        OutPut.viewLadder(lines);
    }
}
