package ladder.service;

import ladder.domain.Ladder;
import ladder.domain.LadderGame;
import ladder.domain.LadderPrize;
import ladder.domain.Players;
import ladder.utils.StringUtils;

import java.util.List;
import java.util.Map;

public class LadderService {

    private static final String COMMA = ",";
    private static final String ALL = "all";

    public LadderGame createLadderGame(final String inputName,
                                       final String inputHeight,
                                       final String inputPrize) {
        List<String> names = StringUtils.split(inputName, COMMA);
        List<String> gamePrize = StringUtils.split(inputPrize, COMMA);
        int height = StringUtils.parse(inputHeight);

        Players players = Players.of(names);
        LadderPrize ladderPrize = new LadderPrize(gamePrize);
        Ladder ladder = Ladder.of(players.size(), height, ladderPrize);

        return new LadderGame(players, ladder);
    }

    public Map<String, String> startGameOfPlayer(final String inputName, final LadderGame ladderGame) {
        if (inputName.equals(ALL)) {
            return findAllPlayer(ladderGame);
        }

        return findOnePlayer(inputName, ladderGame);
    }

    private Map<String, String> findAllPlayer(final LadderGame ladderGame) {
        return ladderGame.getResultAll();
    }

    private Map<String, String> findOnePlayer(final String inputName, final LadderGame ladderGame) {
        return ladderGame.getResult(inputName);
    }
}
