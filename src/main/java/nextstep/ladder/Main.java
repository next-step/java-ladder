package nextstep.ladder;

import nextstep.ladder.controller.LadderGame;
import nextstep.ladder.view.LadderGameView;

public class Main {

    public static void main(String[] args) {
        LadderGame.start(new LadderGameView());
    }
}
