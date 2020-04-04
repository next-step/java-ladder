package ladder.service;

import ladder.domain.LadderGame;
import ladder.domain.Players;
import ladder.utils.StringUtils;

import java.util.List;

public class LadderService {

    private static final String NAME_DELIMITER = ",";

    public LadderGame createLadder(final String inputName, final int height) {
        List<String> names = StringUtils.splitStringToList(inputName, NAME_DELIMITER);
        Players players = Players.of(names);

        LadderGame game = LadderGame.createLadder(players, height);
        return game;
    }
}
