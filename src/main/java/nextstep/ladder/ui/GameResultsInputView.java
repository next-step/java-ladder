package nextstep.ladder.ui;

import java.util.Scanner;

public class GameResultsInputView {
    private static final String GAME_RESULT_INPUT_COMMENT = System.lineSeparator() + "결과를 보고 싶은 사람은?";

    private GameResultsOutputView gameResultsOutputView;

    public GameResultsInputView(GameResultsOutputView gameResultsOutputView) {
        this.gameResultsOutputView = gameResultsOutputView;
    }

    public void startGameResult(Scanner scanner) {
        while (true) {
            System.out.println(GAME_RESULT_INPUT_COMMENT);
            String userInput = scanner.nextLine();

            if (userInput.equals("all")) {
                System.out.println(gameResultsOutputView.parseAllResults());
                break;
            }
            System.out.println(gameResultsOutputView.parseIndividualResult(userInput));
        }
    }
}
