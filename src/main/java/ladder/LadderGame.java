package ladder;

import java.util.Optional;
import ladder.view.InputView;
import ladder.view.PrintView;

public class LadderGame {

    private static final String LOOP_EXIT_COMMAND = "exit";

    private final LadderInitializer initializer;
    private final LadderGamePlayer gamePlayer;

    public LadderGame() {
        this.initializer = new LadderInitializer();
        this.gamePlayer = new LadderGamePlayer();
    }

    public static void main(String[] args) {
        LadderGame game = new LadderGame();
        game.start();
    }

    private void start() {
        LadderGameData gameData = init();
        printLadder(gameData);
        play(gameData);
    }

    private LadderGameData init() {
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

    private void play(LadderGameData gameData) {
        boolean flag = false;
        while (!flag) {
            LadderResultDto resultDto = getResult(gameData, InputView.getResultName());
            flag = updateFlag(resultDto);

            printResult(resultDto);
        }
    }

    private LadderGameData getInitData(LadderInitDto initDto) {
        try {
            return initializer.init(initDto);
        } catch (Exception e) {
            printInitTryAgain(e);
            return null;
        }
    }

    private int getHeight() {
        try {
            return InputView.getHeight();
        } catch (Exception e) {
            return 0;
        }
    }

    private LadderResultDto getResult(LadderGameData gameData, String resultName) {
        if (LOOP_EXIT_COMMAND.equals(resultName)) {
            return null;
        }

        try {
            return gamePlayer.play(gameData, resultName);
        } catch (Exception e) {
            printResultTryAgain(e);
            return new LadderResultDto();
        }
    }

    private boolean updateFlag(LadderResultDto resultDto) {
        return resultDto == null;
    }

    private void printLadder(LadderGameData gameData) {
        PrintView.printLadder(gameData.getLadder(), gameData.getRewards());
        InputView.clear();
    }


    private void printResult(LadderResultDto resultDto) {
        PrintView.printResult(
                Optional.ofNullable(resultDto)
                        .orElse(new LadderResultDto()));
    }

    private void printInitTryAgain(Exception e) {
        PrintView.printError(e);
        PrintView.printTryAgain();
        InputView.clear();
    }

    private void printResultTryAgain(Exception e) {
        PrintView.printError(e);
    }

}
