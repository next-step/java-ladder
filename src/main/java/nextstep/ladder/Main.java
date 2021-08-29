package nextstep.ladder;

import nextstep.ladder.domain.impl.BoardConsumer;
import nextstep.ladder.domain.impl.Player;
import nextstep.ladder.domain.engine.Board;
import nextstep.ladder.domain.engine.BoardCreator;
import nextstep.ladder.domain.engine.PlayResult;
import nextstep.ladder.domain.factory.LadderFactoryBean;
import nextstep.ladder.domain.impl.WinningPrize;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        ResultView.requestPlayerNames();
        List<Player> players = InputView.inputPlayerNames();

        ResultView.requestWinningPrizes();
        List<WinningPrize> winningPrizes = InputView.inputWinningPrizes();

        BoardConsumer boardConsumer = new BoardConsumer(players, winningPrizes);

        ResultView.requestLadderHeight();
        int ladderHeight = InputView.inputLadderHeight();

        BoardCreator ladderFactory = LadderFactoryBean.createLadderFactory();
        Board board = ladderFactory.create(players.size(), ladderHeight);

        ResultView.printLadderShape(boardConsumer, board);

        PlayResult playResult = board.play();

        while (true) {
            ResultView.requestPlayerNameForResult();
            List<Player> playersForResult = InputView.inputPlayerNameForResult(players);
            boardConsumer.validateNotParticipatePlayer(playersForResult);

            ResultView.printResult(playResult, boardConsumer, playersForResult);
        }
    }
}
