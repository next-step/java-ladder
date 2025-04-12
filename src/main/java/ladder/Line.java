package ladder;

import java.util.*;

class Line {
    private final List<Boolean> points;

    public Line(int countOfParticipants) {
        points = new ArrayList<>();
        Random random = new Random();
        boolean previous = false;
        for (int i = 0; i < countOfParticipants - 1; i++) {
            boolean current = false;
            if (!previous) {
                current = random.nextBoolean();
            }
            points.add(current);
            previous = current;
        }
    }

    public String draw() {
        StringBuilder sb = new StringBuilder();
        for (Boolean point : points) {
            sb.append("|");
            sb.append(point ? "-----" : "     ");
        }
        sb.append("|");
        return sb.toString();
    }
}