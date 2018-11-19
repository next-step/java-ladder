package ladder.domain;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.IntStream;

public class Line {

    private static final int START_POINT = 0;
    private static final int DEFAULT_ONE = 1;

    private ArrayList<Point> points;

    public Line (People people) {
        points = new ArrayList<>();
        int personCountForLine = people.personCountForLine();
        IntStream.range(START_POINT, personCountForLine).forEach(count -> points.add(makePoints(people, count)));
    }

    private Point makePoints(People people, int count) {

        boolean result = new Random().nextBoolean();
        Person person = people.getPerson(count);

        if (count == START_POINT) {
            return new Point(result, person);
        }

        if (isNotValidateLine(points.get(count - DEFAULT_ONE).isValue(), result))
            return new Point(false, person);

        return new Point(result, person);
    }

    public boolean isNotValidateLine(boolean preResult, boolean result) {
        return preResult && result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("    |");
        points.forEach(point -> stringBuilder.append(point.toString()));
        return stringBuilder.toString();
    }

    public Person findNextStep(Person person) {

        for (int i = 0; i < points.size(); i++) {
            Point point = points.get(i);

            if (point.hasPerson(person)) {
                if (i != 0 && points.get(i-1).isValue()) {
                    return points.get(i-1).getPerson();
                }

                if (i != points.size()-1 && points.get(i+1).isValue()) {
                    return points.get(i+1).getPerson();
                }

                return point.getPerson();
            }
        }

        return null;
    }
}
