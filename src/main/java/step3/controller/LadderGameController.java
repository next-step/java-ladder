package step3.controller;

import step3.domain.ladder.*;
import step3.domain.ladder.dto.LadderBuildDTO;
import step3.domain.ladder.dto.LadderDrawDTO;
import step3.domain.ladder.dto.LadderResultDTO;
import step3.domain.ladder.dto.PlayerWinningInfo;
import step3.strategy.MakeLadderLineStrategy;
import step3.view.ConsoleViewImpl;
import step3.view.LadderGameInputView;
import step3.view.LadderGameResultView;
import step3.view.View;

public class LadderGameController {
    public static final String ALL = "ALL";
    public static final String END = "end";
    private final View view;

    public LadderGameController(LadderGameInputView ladderGameInputView,
                                LadderGameResultView ladderGameResultView) {
        view = new ConsoleViewImpl(ladderGameInputView, ladderGameResultView);
    }

    public void play() {
        String playerNames = view.getPlayerNames();
        LadderPlayers players = LadderGame.join(playerNames);

        Integer ladderHeight = view.getLadderHeight();

        String ladderResultString = view.getLadderResult(players.count());
        LadderResults ladderResults = LadderResults.of(ladderResultString);

        Ladder ladder = LadderGame.makeLadder(new LadderBuildDTO(players, ladderHeight), new MakeLadderLineStrategy());

        LadderDrawDTO ladderDrawDTO = new LadderDrawDTO.Builder()
                .ladder(ladder)
                .ladderPlayers(players)
                .ladderResults(ladderResults)
                .build();

        view.draw(ladderDrawDTO);

        LadderGameResults playResults = LadderGame.playAll(players.buildDTO(ladder, ladderResults));

        processFromPlayerName(players, playResults);
    }

    private void processFromPlayerName(LadderPlayers players, LadderGameResults playResults) {
        while (true) {
            String findPlayerName = view.findResultByPlayer(players);

            if (isAll(playResults, findPlayerName) || isEnd(findPlayerName)) break;

            Player picked = players.pick(findPlayerName);
            PlayerWinningInfo resultByPlayer = playResults.findResultByPlayer(picked);

            view.drawPlayResult(resultByPlayer);
        }
    }

    private boolean isEnd(String findPlayerName) {
        return findPlayerName.equalsIgnoreCase(END);
    }

    private boolean isAll(LadderGameResults playResults, String findPlayerName) {
        if (findPlayerName.equalsIgnoreCase(ALL)) {
            view.drawPlayResultAll(playResults);
            return true;
        }
        return false;
    }
}
