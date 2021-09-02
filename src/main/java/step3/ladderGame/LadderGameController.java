package step3.ladderGame;

import step3.ladderGame.domain.ladder.Ladder;
import step3.ladderGame.domain.palyer.Players;
import step3.ladderGame.domain.award.Awards;
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
            List<String> awardNames = Arrays.asList(inputView.inputAwards());
            Awards awards = new Awards(awardNames, playerNames.size());

            int height = inputView.inputHeight();

            Ladder ladder = new Ladder(playerNames.size(), height);

            resultView.printPlayers(playerNames);
            resultView.printLadder(ladder);
            resultView.printAwards(awardNames);

            while (true) {
                String player = inputView.inputPlayer();
                if ("all".equals(player)) {
                    resultView.printWinningAwardAll(players, awards, ladder);
                } else {
                    resultView.printWinningAward(ladder.move(players.findIndex(player)), awards);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
