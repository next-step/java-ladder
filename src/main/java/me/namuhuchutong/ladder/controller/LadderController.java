package me.namuhuchutong.ladder.controller;

import me.namuhuchutong.ladder.domain.Ladder;
import me.namuhuchutong.ladder.domain.Names;
import me.namuhuchutong.ladder.domain.Results;
import me.namuhuchutong.ladder.domain.Rows;
import me.namuhuchutong.ladder.domain.factory.ScaffoldFactory;
import me.namuhuchutong.ladder.dto.LadderResult;
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
    }
}
