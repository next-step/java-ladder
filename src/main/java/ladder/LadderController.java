package ladder;

import ladder.domain.person.People;
import ladder.domain.ladder.ladderline.LadderLines;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderController {

    private final LadderService ladderService;

    public LadderController(LadderService ladderService) {
        this.ladderService = ladderService;
    }

    public void create() {
        OutputView.inputPersonName();
        People people = ladderService.people(InputView.personNameInput());

        OutputView.inputLadderHeight();
        LadderLines ladderLines = ladderService.createLadderLine(people.number(), InputView.ladderHeight());

        OutputView.result(people.toStrings(), ladderLines.toString());
    }
}
