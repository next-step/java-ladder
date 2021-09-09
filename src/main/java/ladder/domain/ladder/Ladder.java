package ladder.domain.ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;
import ladder.domain.user.User;
import ladder.domain.user.Users;
import ladder.strategy.LineGenerateStrategy;

public class Ladder {

    private static final int START_LADDER_INDEX = 0;

    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder createLadder(LadderHeight height, Users users, LineGenerateStrategy lineGenerateStrategy) {
        List<Line> lines = new ArrayList<>();
        IntStream.range(START_LADDER_INDEX, height.value())
            .forEach(index -> lines.add(Line.generateRandomLine(users, lineGenerateStrategy)));
        return new Ladder(lines);
    }

    public List<Line> value() {
        return Collections.unmodifiableList(lines);
    }

    public int calculateEndPoint(int start) {
        int now = start;
        for (Line line : lines) {
            now = line.move(now);
        }
        return now;
    }

    public LadderResult createResult(Users users, LadderEndPoints endPoints) {
        Map<User, String> result = new HashMap<>();

        // 현재 유저의 위치가 있어야 calculatePoints(start)가능
        List<User> usersList = users.value();
        for (int i = 0; i < usersList.size(); i++) {
            int nowUserResultPoint = calculateEndPoint(i);
            result.put(usersList.get(i), endPoints.findByPosition(nowUserResultPoint));
        }

        return new LadderResult(result);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ladder ladder = (Ladder) o;
        return Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }

}
