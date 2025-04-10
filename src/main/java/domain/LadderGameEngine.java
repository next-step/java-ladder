package domain;

import java.util.List;

public class LadderGameEngine {
    public static int move(Ladder ladder, int startIndex) {
        int position = startIndex;

        for (Line line : ladder.getLines()) {
            List<Boolean> points = line.getPoints();

            if (position < points.size() && points.get(position)) {
                position++;
            } else if (position > 0 && points.get(position - 1)) {
                position--;
            }
        }

        return position;
    }
}