package nextstep.ladder;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderBuilder;
import nextstep.ladder.domain.Player;
import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.Result;
import nextstep.ladder.domain.ResultOfGame;
import nextstep.ladder.domain.Results;
import nextstep.ladder.domain.line.RandomLineStrategy;
import nextstep.ladder.view.OutputView;

public class LadderGame {
    public static String ALL_COMMAND = "all";
    public static String QUIT_COMMAND = "quit";

    public static void main(String[] args) {
        //final List<String> names = InputView.inputNamesOfPlayer();
        //final int height = InputView.inputHeight();
        // for easy test
        final List<String> names = List.of("n1", "n2", "n3", "n4", "n5");
        final int height = 10;
        final List<String> resultList = List.of("r1", "r2", "r3", "r4", "r5");
        final Players players = Players.of(names);
        final Results results = Results.of(resultList);
        final LadderBuilder ladderBuilder = LadderBuilder.of(players, results);
        final Ladder ladder = ladderBuilder.build(height, new RandomLineStrategy());

        OutputView.printPlayerList(players);
        OutputView.printLadder(ladder);
        OutputView.printResult(results);

        // todo result of players from ladder + player + result
        ResultOfGame resultOfGame = ResultOfGame.of(Map.of(Player.of("n1"), Result.of("r4"),
                Player.of("n2"), Result.of("r2"),
                Player.of("n3"), Result.of("r3"),
                Player.of("n4"), Result.of("r1")));

        List<String> resultCommand = List.of("n1", "n3", ALL_COMMAND, QUIT_COMMAND);
        Iterator<String> iter = resultCommand.iterator();
        String nameOfUser = "";
        while(!nameOfUser.equalsIgnoreCase(QUIT_COMMAND) && iter.hasNext()) {
            nameOfUser = iter.next();
            if (nameOfUser.equalsIgnoreCase(QUIT_COMMAND)) {
                break;
            }

            OutputView.printResultOfPlayers(nameOfUser, resultOfGame);
        }
    }
}
