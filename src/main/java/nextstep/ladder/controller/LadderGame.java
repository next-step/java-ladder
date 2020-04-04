package nextstep.ladder.controller;

import nextstep.ladder.Ladder;
import nextstep.ladder.Line;
import nextstep.ladder.Person;
import nextstep.ladder.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LadderGame {
    public static Ladder createLadder(List<Person> persons, int height) {
        return new Ladder(persons.size(), height);
    }
}
