package nextstep.ladder;

import nextstep.ladder.domain.Board;
import nextstep.ladder.domain.BoardConsumer;
import nextstep.ladder.domain.Player;
import nextstep.ladder.domain.line.Line;
import nextstep.ladder.domain.line.LineCreator;
import nextstep.ladder.domain.winningPrize.WinningPrize;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        ResultView.requestPlayerNames();
        List<Player> players = InputView.inputPlayerNames();

        ResultView.requestWinningPrizes();
        List<WinningPrize> winningPrizes = InputView.inputWinningPrizes();

        BoardConsumer boardConsumer = new BoardConsumer(players, winningPrizes);

        ResultView.requestLadderHeight();
        int ladderHeight = InputView.inputLadderHeight();

        List<Line> lines = LineCreator.createLineList(players.size(), ladderHeight);
        Board board = Board.from(lines);

        ResultView.printLadderShape(boardConsumer, board);

        Map<Integer, Integer> playResult = board.play();

        while (true) {
            ResultView.requestPlayerNameForResult();
            List<Player> playersForResult = InputView.inputPlayerNameForResult(players);
            boardConsumer.validateNotParticipatePlayer(playersForResult);

            ResultView.printResult(playResult, boardConsumer, playersForResult);
        }
    }
}
