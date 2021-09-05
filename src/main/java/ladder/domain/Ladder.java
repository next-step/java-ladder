package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static ladder.domain.Line.init;

public class Ladder {
    private static final int MIN_COUNT = 1;

    private final List<Line> lines;

    public Ladder(LadderHeight height, int count) {
        this.lines = createLines(height, count);
    }

    private List<Line> createLines(LadderHeight height, int count) {
        validateCount(count);
        return Stream.generate(() -> init(count))
                .limit(height.toInt())
                .collect(Collectors.toList());
    }

    private void validateCount(int count) {
        if (count < MIN_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    public List<Result> results(Users users, WinningItems winningItems) {
        List<Result> results = new ArrayList<>();

        for (int startPosition = 0; startPosition < users.usersCount(); startPosition++) {
            int resultPosition = resultPosition(startPosition);

            User user = users.getUserToPosition(startPosition);
            WinningItem item = winningItems.getItemToPosition(resultPosition);

            results.add(new Result(user, item));
        }
        return results;
    }

    private int resultPosition(int startPosition) {
        //todo Stream 으로 작성
        int position = startPosition;
        for (Line line : lines) {
            position = line.move(position);
        }
        return position;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

}
