package step3.controller;

import step3.domain.ladder.*;
import step3.domain.ladder.dto.LadderBuildDTO;
import step3.domain.ladder.dto.LadderDrawDTO;
import step3.domain.ladder.dto.LadderResultDTO;
import step3.strategy.MakeLadderLineStrategy;
import step3.view.ConsoleViewImpl;
import step3.view.LadderGameInputView;
import step3.view.LadderGameResultView;
import step3.view.View;

public class LadderGameController {
    private final View view;

    public LadderGameController(LadderGameInputView ladderGameInputView,
                                LadderGameResultView ladderGameResultView) {
        view = new ConsoleViewImpl(ladderGameInputView, ladderGameResultView);
    }

    public void play() {
        String playerNames = view.getPlayerNames();
        Integer ladderHeight = view.getLadderHeight();

        LadderPlayers players = LadderGame.join(playerNames);

        String ladderResultString = view.getLadderResult(players.count());
        LadderResults ladderResults = LadderResults.of(ladderResultString);

        Ladder ladder = LadderGame.makeLadder(new LadderBuildDTO(players, ladderHeight), new MakeLadderLineStrategy());

        LadderDrawDTO ladderDrawDTO = new LadderDrawDTO.Builder()
                .ladder(ladder)
                .ladderPlayers(players)
                .ladderResults(ladderResults)
                .build();

        view.draw(ladderDrawDTO);

        String findPlayerName = view.findResultByPlayer(players);
        Player picked = players.pick(findPlayerName);
        Point resultPoint = LadderGame.play(picked, ladder);

        /*LadderResultDTO resultDTO = ladderResults.resultByPoint(resultPoint.getX());
        view.drawPlayResult(resultDTO);*/
    }
}
