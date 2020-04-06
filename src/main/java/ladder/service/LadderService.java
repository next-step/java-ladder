package ladder.service;

import ladder.domain.LadderGame;
import ladder.domain.Players;
import ladder.utils.StringUtils;

import java.util.List;

public class LadderService {

    private static final String NAME_DELIMITER = ",";

    public LadderGame createLadder(final String inputName, final String inputHeight) {
        List<String> names = StringUtils.split(inputName, NAME_DELIMITER);
        int height = StringUtils.parse(inputHeight);
        Players players = Players.of(names);

        LadderGame game = LadderGame.createLadder(players, height);
        return game;
    }
}
