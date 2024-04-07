package nextstep.ladder;

import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.util.ConsoleUtil;

import java.util.List;

public class LadderGameApplication {

    public static void main(String[] args) {
        List<String> playerNames = ConsoleUtil.inputPlayerNames();
        int height = ConsoleUtil.inputHeight();

        LadderGame ladderGame = LadderGame.of(playerNames, height);

        ConsoleUtil.printGameResults(ladderGame);
    }
}
