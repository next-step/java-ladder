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
    private static final String RESULT_GAME_ALL = "all";

    public static void main(String[] args) {
        ladderGame();
    }

    public static void ladderGame() {
        InputView inputView = new InputView(new Scanner(System.in));

        List<Player> players = addPlayers(inputView.inputPlayers());
        Result result = new Result(inputView.inputLadderReward());
        Ladder ladder = new Ladder(inputView.inputLadderHeight(), players.size());

        ResultView.printResult(players, ladder.getLines(), result);

        while(printPlayerResult(inputView.inputPlayerName(), players, result, ladder)){
            System.out.println();
        }
    }

    private static List<Player> addPlayers(String playerText) {

        return Arrays.stream(playerText.split(NAME_REX_PATTERN))
                .map(Player::new)
                .collect(Collectors.toList());
    }

    private static boolean printPlayerResult(String inputPlayer, List<Player> players, Result result, Ladder ladder) {

        ResultView.printResultText();

        if (RESULT_GAME_ALL.equals(inputPlayer)) {
            IntStream.range(0, players.size()).forEach(
                    index -> printPlayerResultWithName(index, players.get(index), result, ladder));

            return false;
        }

        int point = players.indexOf(new Player(inputPlayer));
        ResultView.printPlayerResult(result.getValue(players.get(point).getPlayerPoint(point, ladder)));

        return true;

    }

    private static void printPlayerResultWithName(int index, Player player, Result result, Ladder ladder) {
        ResultView.printPlayerResultWithName(player.getName(), result.getValue(player.getPlayerPoint(index, ladder)));
    }
}
