package nextstep.ladder.controller;

import nextstep.ladder.Ladder;
import nextstep.ladder.Line;
import nextstep.ladder.Person;
import nextstep.ladder.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {
    public static Ladder createLadder(List<Person> persons, int height) {
        List<Line> lines = new ArrayList<>();

        for(int i = 0; i < height; i++) {
            lines.add(createLine(i, persons));
        }
        return new Ladder(lines);
    }

    private static Line createLine(int pointY, List<Person> persons) {
        List<Point> points = persons.stream()
                .map(person -> new Point(persons.indexOf(person), pointY, true))
                .collect(Collectors.toList());

        return new Line(points);
    }
}
