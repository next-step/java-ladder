package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class PersonsFactory {

    public static Persons personsFixture() {
        List<Person> gamers = new ArrayList<>();
        gamers.add(Person.of("Pobi1"));
        gamers.add(Person.of("Pobi2"));
        gamers.add(Person.of("Pobi3"));
        return new Persons(gamers);
    }

}
