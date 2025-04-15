package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Line {
    private final List<Boolean> points = new ArrayList<>();

    Line (int countOfPerson) {
        Random random = new Random();
        for (int i = 0; i < countOfPerson - 1; i++) {
            if (i > 0 && points.get(i - 1)) {
                this.points.add(false);
                continue;
            }
            this.points.add(random.nextBoolean());
        }
    }

    Line (int countOfPerson, List<Boolean> points) {
        this.points.addAll(points);
    }

    void printLine() {
        StringBuilder lineRepresentation = new StringBuilder();
        lineRepresentation.append(" ".repeat(4));
        for (Boolean point : points) {
            lineRepresentation.append("|");
            if (point) {
                lineRepresentation.append("-".repeat(5));
            } else {
                lineRepresentation.append(" ".repeat(5));
            }
        }
        lineRepresentation.append("|");
        System.out.println(lineRepresentation);
    }
}
