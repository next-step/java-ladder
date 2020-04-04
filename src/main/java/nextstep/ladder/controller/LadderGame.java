package nextstep.ladder.controller;

import nextstep.ladder.Ladder;
import nextstep.ladder.Line;
import nextstep.ladder.Person;
import nextstep.ladder.Point;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    public static Ladder createLadder(List<Person> persons, int height) {
        List<Line> lines = new ArrayList<>();

        for(int i = 0; i < height; i++) {
            lines.add(createLine(i, persons));
        }
        return new Ladder(lines);
    }

    private static Line createLine(int i, List<Person> persons) {
        List<Point> points = new ArrayList<>();

        for(int j = 0; j < persons.size(); j++) {
            Point point = new Point(j, i, true);
            points.add(point);
        }

        return new Line(points);
    }
}
