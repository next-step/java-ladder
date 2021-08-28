package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class PersonsFactory {

    public static Players personsFixture(String... names) {
        List<Person> gamers = new ArrayList<>();

        for (String name : names) {
            gamers.add(Person.of(name));
        }

        return Players.from(gamers);
    }

}
