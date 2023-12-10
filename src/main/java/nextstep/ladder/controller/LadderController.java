package nextstep.ladder.controller;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Names;
import nextstep.ladder.view.InputView;

public class LadderController {
    public static void main(String[] args) {
        Names names = InputView.inputNames();
        Height height = InputView.inputHeight();
    }
}
