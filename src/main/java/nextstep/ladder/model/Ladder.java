package nextstep.ladder.model;

import nextstep.ladder.exception.MinimumException;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Ladder {

    private static final String MINIMUM_PEOPLE_MESSAGE = "참여자 수는 최소 2인 이상입니다.";
    private static final String MINIMUM_LINE_MESSAGE = "사다리의 행 길이는 최소 2인 이상입니다.";
    private static final int MINIMUM_ROW_LENGTH = 2;
    private final List<Person> people;
    private final List<Line> lines;

    private Ladder(List<Person> people, List<Line> lines) {
        this.people = people;
        this.lines = lines;
    }

    private static <T> void isMinimum(List<T> list, String message) {
        Optional.ofNullable(list)
                .map(List::size)
                .filter(size -> MINIMUM_ROW_LENGTH < size)
                .orElseThrow(() -> new MinimumException(message));
    }

    public static Ladder create(List<Person> people, int maxHeight) {
        isMinimum(people, MINIMUM_PEOPLE_MESSAGE);

        List<Line> lines = Line.create(people.size(), maxHeight);
        isMinimum(lines, MINIMUM_LINE_MESSAGE);

        return new Ladder(people, lines);
    }

    public List<Person> people() {
        return Collections.unmodifiableList(this.people);
    }

    public List<Line> lines() {
        return Collections.unmodifiableList(this.lines);
    }
}
