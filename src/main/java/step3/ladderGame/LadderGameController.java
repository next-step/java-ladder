package step3.ladderGame;

import step3.ladderGame.domain.ladder.Ladder;
import step3.ladderGame.domain.palyer.Players;
import step3.ladderGame.domain.result.Results;
import step3.ladderGame.view.InputView;
import step3.ladderGame.view.ResultView;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LadderGameController {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            InputView inputView = new InputView(scanner);
            ResultView resultView = new ResultView();

            List<String> playerNames = Arrays.asList(inputView.inputPlayers());
            Players players = new Players(playerNames);
            List<String> resultNames = Arrays.asList(inputView.inputPrizes());
            Results results = new Results(resultNames, playerNames.size());

            int height = inputView.inputHeight();

            Ladder ladder = new Ladder(playerNames.size(), height);

            resultView.printPlayers(playerNames);
            resultView.printLadder(ladder);
            resultView.printResults(resultNames);

            while (true) {
                String player = inputView.inputPlayer();
                if ("all".equals(player)) {
                    resultView.printWinningResultAll(players, results, ladder);
                } else {
                    resultView.printWinningResult(ladder.move(players.findIndex(player)), results);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
