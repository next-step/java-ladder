package ladder;

import ladder.domain.ladder.LadderHeight;
import ladder.domain.ladder.LadderWidth;
import ladder.domain.person.People;
import ladder.domain.ladder.ladderline.LadderLines;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderController {

    private final LadderGameCreateService ladderGameCreateService;

    public LadderController(LadderGameCreateService ladderGameCreateService) {
        this.ladderGameCreateService = ladderGameCreateService;
    }

    public void create() {
        OutputView.inputPeople();
        People people = inputPeople();

        OutputView.inputLadderHeight();
        LadderLines ladderLines = ladderGameCreateService.createLadderLine(inputWidth(people), inputHeight());

        OutputView.result(people.toStrings(), ladderLines.toString());
    }

    private People inputPeople() {
        try {
            return ladderGameCreateService.people(InputView.personNameInput());
        } catch (Exception e) {
            OutputView.inputPeopleException();
        }
        return inputPeople();
    }

    private static LadderWidth inputWidth(People people) {
        try {
            return new LadderWidth(people.number());
        } catch (Exception e) {
            OutputView.inputLadderHeightException();
        }
        return inputWidth(people);
    }

    private static LadderHeight inputHeight() {
        try {
            return new LadderHeight(InputView.ladderHeight());
        } catch (Exception e) {
            OutputView.inputLadderHeightException();
        }
        return inputHeight();
    }
}
