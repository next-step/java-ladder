package nextstep.ladder;

import nextstep.ladder.domain.init.LadderGameInitInfo;
import nextstep.ladder.domain.init.LadderInitInfo;
import nextstep.ladder.domain.init.LadderSize;
import nextstep.ladder.domain.init.PlayersAndGifts;
import nextstep.ladder.dto.MatchResult;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.List;

public class LadderConsoleGame {
    private static final String EXIT = "EXIT";
    private static final String ALL = "ALL";

    public static void main(String[] args) {
        LadderGameInitInfo ladderGameInitInfo = inputInitInfo();

        LadderGame ladderGame = LadderGame.init(ladderGameInitInfo);
        ResultView.printResult(ladderGame.result());

        MatchResult matchResult = ladderGame.match();
        String playerToSee;
        while (!(playerToSee = InputView.inputPlayerToSee()).equalsIgnoreCase(EXIT)) {
            showResult(matchResult, playerToSee);
        }
    }

    private static LadderGameInitInfo inputInitInfo() {
        List<String> playerNames = InputView.inputParticipantsNames();
        List<String> gifts = InputView.inputGifts();
        int ladderHeight = InputView.inputLadderHeight();

        PlayersAndGifts playersAndGifts = PlayersAndGifts.of(playerNames, gifts);
        LadderSize ladderSize = LadderSize.of(playersAndGifts.numberOfPlayers(), ladderHeight);
        LadderInitInfo ladderInitInfo = LadderInitInfo.init(ladderSize);

        return LadderGameInitInfo.of(playersAndGifts, ladderInitInfo);
    }

    private static void showResult(MatchResult matchResult, String playerToSee) {
        if (playerToSee.equalsIgnoreCase(ALL)) {
            ResultView.printAllMatchResult(matchResult);
            return;
        }

        ResultView.printOneResult(matchResult, playerToSee);
    }
}
