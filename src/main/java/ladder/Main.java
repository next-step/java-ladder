package ladder;

import ladder.domain.LadderGame;
import ladder.domain.RandomDirectionMakingStrategy;
import ladder.domain.Result;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            InputView inputView = new InputView(scanner);
            String playerNames = inputView.receivePlayerNames();
            String playResults = inputView.receivePlayResults();
            int ladderHeight = inputView.receiveLadderHeight();

            LadderGame ladderGame = new LadderGame(new RandomDirectionMakingStrategy());
            Result result = ladderGame.play(playerNames, playResults, ladderHeight);
            ResultView.print(result);
            checkPlayResult(inputView, result);
        }
    }

    private static void checkPlayResult(InputView inputView, Result result) {
        String playerName;
        do {
            playerName = inputView.receiveWantedPlayerName();
            findPlayResult(playerName, result);
        } while (!isEqualsToAll(playerName));
    }

    private static void findPlayResult(String playerName, Result result) {
        if (isEqualsToAll(playerName)) {
            ResultView.print(result.getLadderResult());
            return;
        }
        ResultView.print(playerName, result.findPlayResult(playerName));
    }

    private static boolean isEqualsToAll(final String playerName) {
        return "all".equals(playerName);
    }
}
