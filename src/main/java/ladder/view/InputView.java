package ladder.view;

import ladder.domain.Players;
import ladder.domain.Prize;

import java.util.List;

public class InputView {
    private static final String ALL = "ALL";

    private final InputScanner inputScanner;

    public InputView() {
        this.inputScanner = new InputScanner();
    }

    public Players inputPlayer() {
        return Players.of(inputScanner.scannerPlayers());
    }

    public Prize inputPrize(int playersCount) {
        List<String> splitPrize = inputScanner.scannerPrizes();
        if (splitPrize.size() != playersCount) {
            throw new IllegalArgumentException("실행 결과는 참가자 수 만큼 입력해 주세요.");
        }

        return Prize.of(splitPrize);
    }

    public int inputLadderHeight() {
        return inputScanner.scannerLadderHeight();
    }

    public String inputPlayerNameForPrize() {
        return inputScanner.scannerPlayerNameForPrize();
    }

    public boolean isAll(String playerName) {
        return ALL.equalsIgnoreCase(playerName);
    }
}
