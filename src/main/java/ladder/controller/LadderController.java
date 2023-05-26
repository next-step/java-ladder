package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.Player;
import ladder.domain.LadderReward;
import ladder.domain.Result;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderController {

    private static final String NAME_REX_PATTERN = ",";

    public static void main(String[] args) {
        ladderGame();
    }

    public static void ladderGame() {
        InputView inputView = new InputView(new Scanner(System.in));

        List<Player> players = addPlayers(inputView.inputPlayers());

        Result result = new Result(inputView.inputLadderReward());

        Ladder ladder = new Ladder(inputView.inputLadderHeight(), players.size());

        ResultView resultView = new ResultView();
        resultView.printResult(players, ladder.getLines(), result);

        String inputPlayer = inputView.inputPlayerName();
        printPlayerResult(inputPlayer, players, result, ladder);
    }

    private static List<Player> addPlayers(String playerText) {

        return Arrays.stream(playerText.split(NAME_REX_PATTERN))
                .map(Player::new)
                .collect(Collectors.toList());
    }

    private static void printPlayerResult(String inputPlayer, List<Player> players, Result result, Ladder ladder) {

        new ResultView().printResultText();

        if ("all".equals(inputPlayer)) {
            IntStream.range(0, players.size()).forEach(index -> printPlayerResultWithName(index, players.get(index), result, ladder));
            return;
        }

        int point = players.indexOf(new Player(inputPlayer));
        new ResultView().printPlayerResult(result.getValue(players.get(point).getPlayerPoint(point, ladder)));

    }

    private static void printPlayerResultWithName(int index, Player player, Result result, Ladder ladder) {
        ResultView.printPlayerResultWithName(player.getName(), result.getValue(player.getPlayerPoint(index, ladder)));
    }
}
