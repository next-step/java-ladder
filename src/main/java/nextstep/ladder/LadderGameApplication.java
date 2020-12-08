package nextstep.ladder;

import nextstep.ladder.view.InputView;

import java.util.List;

public class LadderGameApplication {
    public static void main(String[] args) {

        InputView inputView = new InputView();
        List<String> names = inputView.inputNames();
        int height = inputView.inputHeight();

    }
}
