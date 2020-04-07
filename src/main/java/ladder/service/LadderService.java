package ladder.service;

import ladder.domain.*;
import ladder.utils.StringUtils;
import ladder.view.LadderResultDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderService {

    private static final String COMMA = ",";
    private static final String ALL = "all";

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

    public LadderResultDto startGameOfPlayer(final String inputName, final LadderGame ladderGame) {
        LadderResultDto ladderResultDto = new LadderResultDto();

        if (inputName.equals("all")) {
            Map<String, String> allPlayer = findAllPlayer(ladderGame);
            ladderResultDto.setResult(allPlayer);
            return ladderResultDto;
        }

        Map<String, String> result = new HashMap<>();
        Map<String, String> onePlayer = findOnePlayer(inputName, ladderGame);
        result.putAll(onePlayer);

        ladderResultDto.setResult(result);
        return ladderResultDto;
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
