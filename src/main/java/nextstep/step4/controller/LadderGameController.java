package nextstep.step4.controller;

import nextstep.step4.dto.LadderResponse;
import nextstep.step4.model.Ladder;
import nextstep.step4.model.LadderFactory;
import nextstep.step4.model.Name;
import nextstep.step4.view.InputView;
import nextstep.step4.view.OutputView;

import java.util.List;

public class LadderGameController {
    private static final Name ALL = new Name("all");
    private final InputView inputView;
    private final OutputView outputView;

    public LadderGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        List<Name> names = inputView.askNames();
        List<String> rewards = inputView.askRewards(names.size());
        int height = inputView.askLadderHeight();

        Ladder ladder = LadderFactory.of(height, names.size());

        outputView.printLadderStatus(names, ladder, rewards);

        LadderResponse response = new LadderResponse(names, ladder.play(), rewards);
        Name name = Name.EMPTY;
        while (!name.equals(ALL)) {
            name = inputView.askNameForConfirm();
            outputView.printNameResult(response, name);
        }
    }
}
