package ladder;

import ladder.domain.Height;
import ladder.domain.People;
import ladder.view.InputView;

public class Main {

    public static void main(String[] args) {
        People people = InputView.participantsNameView();
        Height height = InputView.ladderHeightView();
    }
}
