package ladder;

import ladder.domain.ladder.LadderHeight;
import ladder.domain.ladder.LadderWidth;
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
        LadderLines ladderLines = ladderService.createLadderLine(inputWidth(people), inputHeight());

        OutputView.result(people.toStrings(), ladderLines.toString());
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

    private static LadderWidth inputWidth(People people) {
        try {
            return new LadderWidth(people.number());
        } catch (Exception e) {
            e.printStackTrace();
            OutputView.inputLadderHeightException();
        }
        return inputWidth(people);
    }

    private static LadderHeight inputHeight() {
        try {
            return new LadderHeight(InputView.ladderHeight());
        } catch (Exception e) {
            e.printStackTrace();
            OutputView.inputLadderHeightException();
        }
        return inputHeight();
    }
}
