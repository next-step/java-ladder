package me.namuhuchutong.ladder.controller;

import me.namuhuchutong.ladder.domain.engine.Ladder;
import me.namuhuchutong.ladder.domain.engine.LadderCreator;
import me.namuhuchutong.ladder.domain.engine.dto.NameAndResult;
import me.namuhuchutong.ladder.domain.engine.dto.UserInputInformation;
import me.namuhuchutong.ladder.ui.InputView;
import me.namuhuchutong.ladder.ui.OutputView;

import static me.namuhuchutong.ladder.beans.FactoryBean.*;

public class LadderController {

    private static final String ALL = "all";

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
        NameAndResult nameAndResult = ladder.startLadderGame();
        outputView.printResult(nameAndResult.showLadderToString());
        showEachResult(nameAndResult);
        outputView.printNameAndResult(nameAndResult.getAllResults());
    }

    private void showEachResult (NameAndResult nameAndResult) {
        String input = inputView.inputStringName();
        while (isNotAll(input)) {
            outputView.printNameAndResult(nameAndResult.getResult(input));
            input = inputView.inputStringName();
        }
    }

    private boolean isNotAll(String input) {
        return !ALL.equals(input);
    }
}
