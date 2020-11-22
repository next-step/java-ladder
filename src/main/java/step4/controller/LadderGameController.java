package step4.controller;

import step4.domain.ladder.*;
import step4.domain.ladder.dto.LadderBuildDTO;
import step4.domain.ladder.dto.LadderDrawDTO;
import step4.domain.ladder.dto.PlayerWinningInfo;
import step4.strategy.MakeLadderLineStrategy;
import step4.view.ConsoleViewImpl;
import step4.view.LadderGameInputView;
import step4.view.LadderGameResultView;
import step4.view.View;

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

        view.draw(LadderDrawDTO.Builder()
                .ladder(ladder)
                .ladderPlayers(players)
                .ladderResults(ladderResults)
                .build());

        LadderGameResults playResults = LadderGame.playAll(players.buildDTO(ladder, ladderResults));

        processFromPlayerName(players, playResults);
    }

    private void processFromPlayerName(LadderPlayers players, LadderGameResults playResults) {
        while (true) {
            String findPlayerName = view.findResultByPlayer(players);

            checkBreakCondition(playResults, findPlayerName);

            Player picked = players.pick(findPlayerName);
            PlayerWinningInfo resultByPlayer = playResults.findResultByPlayer(picked);

            view.drawPlayResult(resultByPlayer);
        }
    }

    private void checkBreakCondition(LadderGameResults playResults, String findPlayerName) {
        if (isAll(playResults, findPlayerName) || isEnd(findPlayerName)) {
            System.exit(0);
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
