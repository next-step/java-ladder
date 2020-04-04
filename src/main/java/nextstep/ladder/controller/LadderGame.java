package nextstep.ladder.controller;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Person;

import java.util.List;

public class LadderGame {
    public static Ladder createLadder(List<Person> persons, int height) {
        return new Ladder(persons.size(), height);
    }
}
