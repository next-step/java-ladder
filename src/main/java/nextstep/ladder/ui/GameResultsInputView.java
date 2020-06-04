package nextstep.ladder.ui;

import java.util.Scanner;

public class GameResultsInputView {
    private static final String GAME_RESULT_INPUT_COMMENT = System.lineSeparator() + "결과를 보고 싶은 사람은?";
    private static final String SELECT_ALL = "all";

    private GameResultsOutputView gameResultsOutputView;

    public GameResultsInputView(GameResultsOutputView gameResultsOutputView) {
        this.gameResultsOutputView = gameResultsOutputView;
    }

    public void startPrintGameResult(Scanner scanner) {
        while (true) {
            System.out.println(GAME_RESULT_INPUT_COMMENT);
            String userInput = scanner.nextLine();

            System.out.println(parseResult(userInput));
        }
    }

    public String parseResult(String userInput) {
        if (userInput.equals(SELECT_ALL)) {
            return gameResultsOutputView.parseAllResults();
        }
        return gameResultsOutputView.parseIndividualResult(userInput);
    }
}
