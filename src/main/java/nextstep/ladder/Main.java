package nextstep.ladder;

import nextstep.ladder.domain.Game;
import nextstep.ladder.domain.Player;
import nextstep.ladder.domain.line.Line;
import nextstep.ladder.domain.line.LineCreator;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        ResultView.requestPlayerNames();
        List<Player> players = InputView.inputPlayerNames();

        ResultView.requestWinningPrizes();
        InputView.inputWinningPrizes();

        ResultView.requestLadderHeight();
        int ladderHeight = InputView.inputLadderHeight();

        List<Line> lines = LineCreator.createLineList(players.size(), ladderHeight);

        Game game = Game.of(players, lines);
        ResultView.printLadderShape(game);

        while (true) {
            ResultView.requestPlayerNameForResult();
            List<Player> playersForResult = InputView.inputPlayerNameForResult(players);
            List<Integer> result = game.play(playersForResult);
            ResultView.printResult(playersForResult, result);
        }

    }
}
