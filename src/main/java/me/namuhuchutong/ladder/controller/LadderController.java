package me.namuhuchutong.ladder.controller;

import me.namuhuchutong.ladder.domain.*;
import me.namuhuchutong.ladder.domain.factory.ScaffoldFactory;
import me.namuhuchutong.ladder.dto.LadderResult;
import me.namuhuchutong.ladder.dto.NameAndResult;
import me.namuhuchutong.ladder.dto.UserInputInformation;
import me.namuhuchutong.ladder.ui.InputView;
import me.namuhuchutong.ladder.ui.OutputView;

public class LadderController {

    private final InputView inputView;

    private final ScaffoldFactory scaffoldFactory;

    private final OutputView outputView;

    public LadderController(InputView inputView, ScaffoldFactory scaffoldFactory, OutputView outputView) {
        this.inputView = inputView;
        this.scaffoldFactory = scaffoldFactory;
        this.outputView = outputView;
    }

    public void start() {
        UserInputInformation information = new UserInputInformation(inputView.inputStringNames(),
                                                                    inputView.inputStringResults(),
                                                                    inputView.inputInteger());
        Names names = Names.from(information.getInputNames());
        Rows rows = Rows.createLadder(information.getLadderHeight(),
                                      names.size(),
                                      scaffoldFactory);
        Results results = Results.from(information.getInputResults());
        outputView.printResult(new LadderResult(names, rows, results));
        NameAndResult nameAndResult = new Ladder(rows, names, results).startLadderGame();
        showEachResult(names, nameAndResult);
        outputView.printNameAndResult(nameAndResult.getAllResults());
    }

    private void showEachResult(Names names, NameAndResult nameAndResult) {
        String inputName = inputView.inputStringName();
        while (names.contains(inputName)) {
            outputView.printNameAndResult(nameAndResult.getResult(inputName));
            inputName = inputView.inputStringName();
        }
    }
}
