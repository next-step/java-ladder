package ladder.service;

import ladder.domain.LadderGame;
import ladder.domain.LadderGameResult;
import ladder.domain.Node;
import ladder.domain.Players;
import ladder.utils.StringUtils;

import java.util.List;

public class LadderService {

    private static final String NAME_DELIMITER = ",";

    public LadderGame createLadder(final String inputName,
                                   final String inputHeight,
                                   final String inputResult) {
        List<String> names = StringUtils.split(inputName, NAME_DELIMITER);
        List<String> gameResults = StringUtils.split(inputResult, NAME_DELIMITER);
        int height = StringUtils.parse(inputHeight);
        Players players = Players.of(names);
        LadderGameResult ladderGameResult = new LadderGameResult(gameResults);

        LadderGame game = LadderGame.of(players, height, ladderGameResult);
        return game;
    }

    public Node startGameOfPlayer(final String inputName, LadderGame ladderGame) {
        return ladderGame.getPlayerResult(inputName);
    }
}
