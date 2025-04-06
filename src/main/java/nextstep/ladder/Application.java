package nextstep.ladder;

import nextstep.ladder.controller.LadderGame;
import nextstep.ladder.view.ConsoleInputView;
import nextstep.ladder.view.ConsoleOutputView;

public class Application {
    public static void main(String[] args) {
        LadderGame game = new LadderGame(new ConsoleInputView(), new ConsoleOutputView());
        game.play();
    }
}
