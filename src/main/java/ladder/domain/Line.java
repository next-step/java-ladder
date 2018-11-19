package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static ladder.utils.LadderPointGenerator.generatePoint;

public class Line {

    private static final int ONE = 1;

    private List<Position> positions;

    public Line(List<Position> generatedPoints) {
        this.positions = generatedPoints;
    }

    public static Line newLine(int countOfPerson) {
        List<Position> newPositions = new ArrayList<>();

        firstLine(newPositions);

        IntStream.range(ONE, countOfPerson - ONE)
                .forEach(i -> newPositions.add(Position.generateNextPosition(newPositions.get(i - ONE))));

        lastLine(newPositions, countOfPerson - ONE);

        return new Line(newPositions);
    }

    private static void firstLine(List<Position> newPositions) {
        newPositions.add(Position.generateFirstPosition(generatePoint()));
    }

    private static void lastLine(List<Position> newPositions, int countOfPerson) {
        newPositions.add(Position.generateLastPosition(newPositions.get(countOfPerson - ONE)));
    }

    int moveToNextPoint(int position) {
        return this.positions.get(position).move();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("|");

        return str.append(
                this.positions.stream()
                        .map(Position::toString)
                        .collect(Collectors.joining("|"))
        ).toString();
    }
}
