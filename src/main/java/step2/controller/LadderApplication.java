package step2.controller;

import step2.domain.Ladder;
import step2.domain.Results;
import step2.dto.Height;
import step2.dto.InputDto;
import step2.view.InputView;
import step2.view.OutputView;

public class LadderApplication {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public static void main(String[] args) {
        final InputDto inputDto = inputView.inputValues();
        final Height height = inputView.inputHeight();

        final Ladder ladder = new Ladder(inputDto.getPlayers(), height.height());
        outputView.printLadder(ladder, inputDto.getExecutionResults());

        final Results play = ladder.play();
        System.out.println(play);
    }
}
