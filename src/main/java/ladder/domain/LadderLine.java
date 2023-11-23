package ladder.domain;

import ladder.domain.strategy.CoordinateGeneration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LadderLine {
    private static final int ONE = 1;
    private final List<Coordinate> line;


    public LadderLine(People people, CoordinateGeneration coordinateGeneration) {
        this(makeLine(people, coordinateGeneration));
    }

    public LadderLine(List<Coordinate> list) {
        this.line = list;
    }

    private static List<Coordinate> makeLine(People people, CoordinateGeneration coordinateGeneration) {
        Coordinate coordinate = Coordinate.valueOf(coordinateGeneration.generate());
        List<Coordinate> lineList = new ArrayList<>(List.of(coordinate));

        for (int i = ONE; i < people.ofCoordinateCount(); i++) {
            lineList.add(lineList.get(minusOne(i)).next(coordinateGeneration.generate()));
        }

        return lineList;
    }

    private static int minusOne(int countOfPerson) {
        return countOfPerson - ONE;
    }

    public List<Coordinate> draw() {
        return Collections.unmodifiableList(line);
    }
}
