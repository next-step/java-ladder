package me.namuhuchutong.ladder.controller;

import me.namuhuchutong.ladder.domain.engine.Ladder;
import me.namuhuchutong.ladder.domain.engine.LadderCreator;
import me.namuhuchutong.ladder.domain.engine.dto.LadderResult;
import me.namuhuchutong.ladder.domain.engine.dto.UserInputInformation;
import me.namuhuchutong.ladder.domain.implement.wrapper.Name;
import me.namuhuchutong.ladder.ui.InputView;
import me.namuhuchutong.ladder.ui.OutputView;

import static me.namuhuchutong.ladder.beans.FactoryBean.*;

public class LadderController {

    private final InputView inputView;

    private final OutputView outputView;

    public LadderController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        UserInputInformation information = new UserInputInformation(inputView.inputStringNames(),
                                                                    inputView.inputStringResults(),
                                                                    inputView.inputInteger());
        LadderCreator ladderCreator = ladderCreator();
        Ladder ladder = ladderCreator.createLadder(information);
        LadderResult ladderResult = ladder.startLadderGame();
        outputView.printResult(ladderResult.showLadder());
        showEachResult(ladderResult);
        outputView.printNameAndResult(ladderResult.getAllResults());
    }

    private void showEachResult (LadderResult ladderResult) {
        String input = inputView.inputStringName();
        while (isNotAll(input)) {
            outputView.printNameAndResult(ladderResult.getResult(input));
            input = inputView.inputStringName();
        }
    }

    private boolean isNotAll(String input) {
        Name name = new Name(input);
        return name.isNotAll();
    }
}
