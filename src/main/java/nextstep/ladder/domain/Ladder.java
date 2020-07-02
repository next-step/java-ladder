package nextstep.ladder.domain;

import java.util.Collections;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final int height;

    private final List<Line> lines;

    private static final int FIRST = 1;
    private static final int MINIMUM_USER_COUNT = 2;
    
    private static final String USER_COUNT_EXCEPTION_MESSAGE = "사용자 수는 1 보다 커야 합니다.";
    private static final String HEIGHT_EXCEPTION_MESSAGE = "높이는 0 보다 커야 합니다.";

    public Ladder(int height, int countOfPerson) {
        validateHeight(height);
        validateCountOfPerson(countOfPerson);

        this.height = height;
        this.lines = createLines(height, countOfPerson);
    }


    private void validateCountOfPerson(int countOfPerson) {
        if (countOfPerson < MINIMUM_USER_COUNT) {
            throw new IllegalArgumentException(USER_COUNT_EXCEPTION_MESSAGE);
        }
    }

    private void validateHeight(int height) {
        if (height < FIRST) {
            throw new IllegalArgumentException(HEIGHT_EXCEPTION_MESSAGE);
        }
    }

    private List<Line> createLines(int height, int countOfPerson) {
        return IntStream.rangeClosed(FIRST, height)
                .mapToObj(index -> Line.of(countOfPerson))
                .collect(Collectors.toList());
    }

    public Map<String, String> play(Users users, Rewards results) {
        Map<String, String> map = new HashMap<>();

        for (User user : users.getUsers()) {
            int position = user.getPosition();

            for (Line line : lines) {
                position += line.move(position);
            }
            map.put(user.getName(), results.findReward(position));
        }

        return map;
    }

    public int getHeight() {
        return height;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
