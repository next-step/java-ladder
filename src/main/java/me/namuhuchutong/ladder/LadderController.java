package me.namuhuchutong.ladder;

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
                                                                    inputView.inputInteger());
        Names names = Names.from(information.getInputNames());
        Rows ladder = Rows.createLadder(information.getLadderHeight(),
                                        names.size(),
                                        scaffoldFactory);
        outputView.printResult(new LadderResult(names, ladder));
    }
}
