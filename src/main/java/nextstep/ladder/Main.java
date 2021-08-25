package nextstep.ladder;

import nextstep.ladder.domain.Game;
import nextstep.ladder.domain.line.Line;
import nextstep.ladder.domain.line.LineCreator;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        ResultView.requestPlayerNames();
        List<String> playerNames = InputView.inputPlayerNames();

        ResultView.requestLadderHeight();
        int ladderHeight = InputView.inputLadderHeight();

        List<Line> lines = LineCreator.createLineList(playerNames.size(), ladderHeight);

        Game game = Game.of(playerNames, lines);
        ResultView.printResult(game);
    }
}
