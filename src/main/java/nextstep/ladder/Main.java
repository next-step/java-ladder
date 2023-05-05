package nextstep.ladder;

import nextstep.ladder.domain.Heights;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.view.InputView;

public class Main {
    public static void main(String[] args) {
        Participants participants = InputView.inputNames();
        Heights heights = InputView.inputHeights();
    }
}
