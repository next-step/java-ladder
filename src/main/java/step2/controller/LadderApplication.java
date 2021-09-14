package step2.controller;

import step2.domain.ExecutionResults;
import step2.domain.Ladder;
import step2.domain.Results;
import step2.dto.Height;
import step2.dto.InputDto;
import step2.dto.Players;
import step2.view.InputView;
import step2.view.OutputView;

public class LadderApplication {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public static void main(String[] args) {
        final InputDto inputDto = inputView.inputValues();
        final Height height = inputView.inputHeight();

        final Players players = inputDto.getPlayers();
        final Ladder ladder = new Ladder(players, height.height());
        final ExecutionResults executionResults = inputDto.getExecutionResults();
        outputView.printLadder(ladder, executionResults);

        final Results results = ladder.play();

        final String targetName = inputView.inputTarget();
        outputView.printResults(results.print(targetName, executionResults));
    }
}
