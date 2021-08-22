package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Person;
import nextstep.ladder.view.ResultView;
import java.util.ArrayList;
import java.util.List;

public class LadderGame {

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(Person.of("pob"));
        persons.add(Person.of("pob1"));
        persons.add(Person.of("pob2"));
        persons.add(Person.of("pob3"));

        Ladder ladder = Ladder.of(persons, 5);

        ResultView.show(ladder.getLadderLines(), ladder.persons());
    }
}
