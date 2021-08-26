package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class PersonsFactory {

    public static Persons personsFixture(String... names) {
        List<Person> gamers = new ArrayList<>();

        for (String name : names) {
            gamers.add(Person.of(name));
        }

        return Persons.of(gamers);
    }

}
