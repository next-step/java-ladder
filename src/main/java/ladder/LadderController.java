package ladder;

import ladder.domain.person.Person;
import ladder.domain.ladder.ladderline.LadderLines;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class LadderController {

    private final LadderService ladderService;

    public LadderController(LadderService ladderService) {
        this.ladderService = ladderService;
    }

    public void create() {
        OutputView.inputPersonName();
        List<Person> persons = ladderService.persons(InputView.personNameInput());

        OutputView.inputLadderHeight();
        LadderLines ladderLines = ladderService.createLadderLine(persons.size(), InputView.ladderHeight());

        OutputView.resultGuide();
        OutputView.outputPersonNames(persons.stream()
                .map(Person::toString)
                .collect(Collectors.toList()));
        OutputView.outputLadderLines(ladderLines.toString());
    }
}
