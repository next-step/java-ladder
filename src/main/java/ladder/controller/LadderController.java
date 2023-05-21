package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.Player;
import ladder.domain.LadderReward;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LadderController {

    private static final String NAME_REX_PATTERN = ",";

    public static void main(String[] args) {
        ladderGame();
    }

    public static void ladderGame() {
        InputView inputView = new InputView(new Scanner(System.in));

        List<Player> players = addPlayers(inputView.inputPlayers());
        List<LadderReward> ladderRewards = addResults(inputView.inputLadderReward());

        Ladder ladder = new Ladder(inputView.inputLadderHeight(), players.size());

        ResultView resultView = new ResultView();
        resultView.printResult(players, ladder.getLines(), ladderRewards);

        while(!"all".equals(inputView.inputPlayerName())) {

        }
    }

    private static List<Player> addPlayers(String playerText) {

        return Arrays.stream(playerText.split(NAME_REX_PATTERN))
                .map(Player::new)
                .collect(Collectors.toList());
    }

    private static List<LadderReward> addResults(String resultText) {

        return Arrays.stream(resultText.split(NAME_REX_PATTERN))
                .map(LadderReward::new)
                .collect(Collectors.toList());
    }
}
