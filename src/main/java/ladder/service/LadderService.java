package ladder.service;

import ladder.domain.LadderGame;
import ladder.domain.LadderPrize;
import ladder.domain.Node;
import ladder.domain.Players;
import ladder.utils.StringUtils;

import java.util.List;

public class LadderService {

    private static final String COMMA = ",";

    public LadderGame createLadder(final String inputName,
                                   final String inputHeight,
                                   final String inputResult) {
        List<String> names = StringUtils.split(inputName, COMMA);
        List<String> gameResults = StringUtils.split(inputResult, COMMA);
        int height = StringUtils.parse(inputHeight);
        Players players = Players.of(names);
        LadderPrize ladderPrize = new LadderPrize(gameResults);
        LadderGame game = LadderGame.of(players, height, ladderPrize);

        return game;
    }

    public String startGameOfPlayer(final String inputName, final LadderGame ladderGame) {
        Node last = ladderGame.findPlayerResult(inputName);
        return ladderGame.findPrize(last.getIndex());
    }
}
