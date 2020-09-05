package nextstep.app;

import nextstep.domain.Line;
import nextstep.domain.LineFactory;
import nextstep.domain.Person;
import nextstep.domain.PersonFactory;
import nextstep.view.InputView;
import nextstep.view.OutputView;

import java.util.List;

public class LadderGameApp {

    public static void main(String[] args) {
        List<Person> persons = PersonFactory.createPersons(InputView.receivePersons());
        int ladderHeight = InputView.receiveLadderHeight();
        List<Line> lines = LineFactory.createLines(persons.size(), ladderHeight);
        OutputView.printExecuteResult(persons, lines);
    }

}
