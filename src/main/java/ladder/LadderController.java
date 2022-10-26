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
        OutputView.inputPeople();
        People people = inputPeople();

        OutputView.inputLadderHeight();
        LadderLines ladderLines = ladderService.createLadderLine(people.number(), inputHeight());

        OutputView.result(people.toStrings(), ladderLines.toString());
    }

    private static int inputHeight() {
        try {
            return InputView.ladderHeight();
        } catch (Exception e) {
            e.printStackTrace();
            OutputView.inputLadderHeightException();
        }
        return inputHeight();
    }

    private People inputPeople() {
        try {
            return ladderService.people(InputView.personNameInput());
        } catch (Exception e) {
            e.printStackTrace();
            OutputView.inputPeopleException();
        }
        return inputPeople();
    }
}
