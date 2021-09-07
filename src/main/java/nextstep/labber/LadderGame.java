package nextstep.labber;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class LadderGame {
    private static final int MOVE_LEFT_MIN_INDEX = 0;
    private static final int PREV_CURRENT_DIFFERENCE_INDEX = 1;

    public static Map<String, Integer> findAllResult(List<User> participants, List<Line> ladder) {
        Map<String, Integer> result = new HashMap<>();

        IntStream.range(0 , participants.size())
                .forEach(index -> {
                    result.put(participants.get(index).toString(), findProductNumber(ladder, index));
                });
        return result;
    }

    private static int findProductNumber(List<Line> ladder, int location) {
        for (int i = 0; i < ladder.size(); i++) {
            Line line = ladder.get(i);
            location = move(location, line);
        }
        return location;
    }

    private static int move(int location, Line line) {
        if (line.existLine(location)) {
            return ++location;
        }

        if (location > MOVE_LEFT_MIN_INDEX && line.existLine(location - PREV_CURRENT_DIFFERENCE_INDEX)) {
            return --location;
        }
        return location;
    }
}
