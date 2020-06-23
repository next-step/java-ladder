package nextstep.ladder.controller;

import nextstep.ladder.domain.ExecutionResult;
import nextstep.ladder.domain.ExecutionResults;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderGamePlay;
import nextstep.ladder.domain.Player;
import nextstep.ladder.domain.PlayerName;
import nextstep.ladder.domain.Players;
import nextstep.ladder.view.LadderGameView;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class LadderGame {

    public void playLadderGame() {
        List<String> userNames = LadderGameView.inputUserNames();
        List<String> executionResults = LadderGameView.inputExecutionResults();
        Integer ladderHeight = LadderGameView.inputLadderHeight();
        Ladder ladder = Ladder.of(userNames, executionResults, ladderHeight);
        LadderGameView.viewLadderShape(ladder);

        Players playersFromLadder = ladder.getPlayers();
        ExecutionResults executionResultsFromLadder = ladder.getExecutionResults();
        LadderGamePlay ladderGamePlay = LadderGamePlay.of(ladder);

        while (true) {
            String name = LadderGameView.inputExecutionResultPlayer();
            if (StringUtils.equals(name, "all")) {
                break;
            }

            PlayerName playerName = PlayerName.of(name);
            Player player = playersFromLadder.getPlayer(playerName);
            ExecutionResult result = ladderGamePlay.playLadderGame(player, executionResultsFromLadder);
            LadderGameView.viewExecutionResult(result);
        }

        for (Player player : playersFromLadder.getPlayers()) {
            ExecutionResult result = ladderGamePlay.playLadderGame(player, executionResultsFromLadder);
            LadderGameView.viewAllExecutionResult(player, result);
        }
    }
}
