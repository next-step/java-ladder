package ladder.service;

import ladder.domain.LadderGame;
import ladder.domain.LadderPrize;
import ladder.domain.Node;
import ladder.domain.Players;
import ladder.utils.StringUtils;
import ladder.view.LadderResultDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public LadderResultDto startGameOfPlayer(final String inputName, final LadderGame ladderGame) {
        Node last = ladderGame.findPlayerResult(inputName);
        String prize = ladderGame.findPrize(last.getIndex());

        Map<String, String> result = new HashMap<>();
        result.put(inputName, prize);

        LadderResultDto ladderResultDto = new LadderResultDto();
        ladderResultDto.setResult(result);
        return ladderResultDto;
    }
}
