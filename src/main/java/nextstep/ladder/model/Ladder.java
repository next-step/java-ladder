package nextstep.ladder.model;

import nextstep.ladder.exception.MinimumException;

import java.util.List;
import java.util.Optional;

public class Ladder {

    private final static String MINIMUM_PEOPLE_MESSAGE = "참여자 수는 최소 2인 이상입니다.";
    private final static String MINIMUM_LINE_MESSAGE = "참여자 수는 최소 2인 이상입니다.";
    private final List<Person> people;
    private final List<Line> lines;

    private Ladder(List<Person> people, List<Line> lines) {
        this.people = people;
        this.lines = lines;
    }

    private static <T> void check(List<T> list, String message) {
        Optional.ofNullable(list)
                .map(List::size)
                .filter(size -> 2 < size)
                .orElseThrow(() -> new MinimumException(message));
    }

    public static Ladder start(List<Person> people, List<Line> lines) {
        check(people, MINIMUM_PEOPLE_MESSAGE);
        check(lines, MINIMUM_LINE_MESSAGE);
        return new Ladder(people, lines);
    }

    public List<Person> people() {
        return this.people;
    }

    public List<Line> lines() {
        return this.lines;
    }
}
