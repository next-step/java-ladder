package ladder;

import java.util.Optional;
import ladder.view.InputView;
import ladder.view.PrintView;

public class LadderGame {

    private static final String LOOP_EXIT_COMMAND = "exit";

    public LadderGame() {
    }

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        LadderGameData gameData = init();
        printLadder(gameData);
        play(gameData);
    }

    private static LadderGameData init() {
        LadderGameData gameData = null;
        while (gameData == null) {
            LadderInitDto initDto = new LadderInitDto(
                    InputView.getNames(),
                    InputView.getRewards(),
                    getHeight());
            gameData = getInitData(initDto);
        }

        return gameData;
    }

    private static void play(LadderGameData gameData) {
        boolean flag = false;
        while (!flag) {
            LadderResultDto resultDto = getResult(gameData, InputView.getResultName());
            flag = updateFlag(resultDto);

            printResult(resultDto);
        }
    }

    private static LadderGameData getInitData(LadderInitDto initDto) {
        LadderInitializer initializer = new LadderInitializer();
        try {
            return initializer.init(initDto);
        } catch (Exception e) {
            printInitTryAgain(e);
            return null;
        }
    }

    private static int getHeight() {
        try {
            return InputView.getHeight();
        } catch (Exception e) {
            return 0;
        }
    }

    private static LadderResultDto getResult(LadderGameData gameData, String resultName) {
        if (LOOP_EXIT_COMMAND.equals(resultName)) {
            return null;
        }

        LadderGamePlayer gamePlayer = new LadderGamePlayer();
        try {
            return gamePlayer.play(gameData, resultName);
        } catch (Exception e) {
            printResultTryAgain(e);
            return new LadderResultDto();
        }
    }

    private static boolean updateFlag(LadderResultDto resultDto) {
        return resultDto == null;
    }

    private static void printLadder(LadderGameData gameData) {
        PrintView.printLadder(gameData.getLadder(), gameData.getRewards());
        InputView.clear();
    }


    private static void printResult(LadderResultDto resultDto) {
        PrintView.printResult(
                Optional.ofNullable(resultDto)
                        .orElse(new LadderResultDto()));
    }

    private static void printInitTryAgain(Exception e) {
        PrintView.printError(e);
        PrintView.printTryAgain();
        InputView.clear();
    }

    private static void printResultTryAgain(Exception e) {
        PrintView.printError(e);
    }

}
