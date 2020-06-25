package nextstep.step2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lines {

    private final List<Line> lines;

    public static Lines of(int numberOfPeople) {
        checkNegative(numberOfPeople);
        return new Lines(numberOfPeople);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public List<Line> createLines(int numberOfPeople) {
        return addLine(new ArrayList<>(), numberOfPeople);
    }

    private static void checkNegative(int numberOfPeople) {
        if(numberOfPeople <= 0) {
            throw new IllegalArgumentException(Error.NOT_ALLOW_LESS_THAN_ZERO);
        }
    }

    private Lines(int numberOfPeople) {
        this.lines = createLines(numberOfPeople);
    }

    private List<Line> addLine(ArrayList<Line> lines, int numberOfPeople) {
        Line line = Line.first();
        for (int i = 1; i < numberOfPeople; i++) {
            lines.add(line);
            line = line.next();
        }
        return lines;
    }


    @Override
    public String toString() {
        return "Lines{" +
                ", lines=" + lines +
                '}';
    }

}
