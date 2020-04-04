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
        List<Line> lines = Stream
                .generate(() -> createLine(persons))
                .limit(height)
                .collect(Collectors.toList());

        return new Ladder(lines);
    }

    private static Line createLine(List<Person> persons) {
        List<Point> points = persons.stream()
                .map(person -> new Point(0, true))
                .collect(Collectors.toList());

        return new Line(points);
    }
}
