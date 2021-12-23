package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;
import java.util.Scanner;

public class Game {
    public static final String ALL = "all";

    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));

        Players players = Players.of(inputView.players());
        Results results = Results.of(inputView.results());
        Ladder ladder = Ladder.of(players, Height.of(inputView.height()));
        ResultView.printLadderResult(ladder, players, results);

        String resultName = "";
        while (true) {
            resultName = inputView.resultByName();
            if (ALL.equalsIgnoreCase(resultName)) {
                List<LadderResult> gameResult = ladder.findAllResult(players, results);
                ResultView.printAllGameResult(gameResult);
                break;
            }
            LadderResult gameResult = ladder.findOneResult(players, results, resultName);
            ResultView.printGameResult(gameResult);
        }

        inputView.close();
    }

}
