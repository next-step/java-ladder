package ladder;

import ladder.domain.ladder.LadderHeight;
import ladder.domain.ladder.LadderWidth;
import ladder.domain.person.People;
import ladder.domain.ladder.ladderline.LadderLines;
import ladder.util.LadderOutputConverter;
import ladder.view.InputView;
import ladder.view.output.LadderGameCreateOutputView;

public class LadderController {

    private final LadderGameCreateService ladderGameCreateService;

    public LadderController(LadderGameCreateService ladderGameCreateService) {
        this.ladderGameCreateService = ladderGameCreateService;
    }

    public void create() {
        People people = inputPeople();

        LadderLines ladderLines = ladderGameCreateService.createLadderLine(new LadderWidth(people.number()), inputHeight());

        LadderGameCreateOutputView.result(people.toStrings(), LadderOutputConverter.ladderLinesOutput(ladderLines));
    }

    private People inputPeople() {
        try {
            return ladderGameCreateService.people(InputView.personNameInput());
        } catch (Exception e) {
            LadderGameCreateOutputView.inputPeopleException();
        }
        return inputPeople();
    }

    private static LadderHeight inputHeight() {
        try {
            return new LadderHeight(InputView.ladderHeight());
        } catch (Exception e) {
            LadderGameCreateOutputView.inputLadderHeightException();
        }
        return inputHeight();
    }
}
