package ladder.service;

import ladder.domain.*;
import ladder.utils.StringUtils;

import java.util.HashMap;
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
        Map<String, String> result = new HashMap<>();
        for (Player player : ladderGame.getPlayers().getPlayers()) {
            String name = player.getName();
            Map<String, String> onePlayer = findOnePlayer(name, ladderGame);
            result.putAll(onePlayer);
        }
        return result;
    }

    private Map<String, String> findOnePlayer(final String inputName, final LadderGame ladderGame) {
        Map<String, String> result = new HashMap<>();
        Node last = ladderGame.findPlayerResult(inputName);
        String prize = ladderGame.findPrize(last.getIndex());
        result.put(inputName, prize);

        return result;
    }
}
