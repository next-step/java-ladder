package ladder.domain;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder implements Iterable<HorizontalLine> {

    private static final int MINIMUM_HEIGHT = 1;
    private static final int MINIMUM_NUMBER_PERSON = 2;

    private final List<HorizontalLine> lines;

    public Ladder(List<HorizontalLine> lines) {
        this.lines = lines;
    }

    public static Ladder create(int countOfPerson, int height, LineStrategy lineStrategy) {
        checkValid(countOfPerson, height);
        return new Ladder(IntStream.rangeClosed(1, height)
            .mapToObj(i -> HorizontalLine.create(countOfPerson, lineStrategy))
            .collect(Collectors.toList()));
    }

    public Map<User, String> execute(Users users, Results results) {
        Map<User, String> gameResult = new HashMap<>();

        IntStream.range(0, users.count())
            .forEach(position -> gameResult.put(users.get(position), results.get(climbLines(position))));

        return gameResult;
    }

    private int climbLines(int position) {
        for (HorizontalLine line : lines) {
            position = line.move(position);
        }

        return position;
    }

    private static void checkValid(int countOfPerson, int height) {
        if (countOfPerson < MINIMUM_NUMBER_PERSON){
            throw new IllegalArgumentException("사람의 수는 2이상이어야 합니다.");
        }
        if (height < MINIMUM_HEIGHT) {
            throw new IllegalArgumentException("사다리 높이는 양수 값을 가져야합니다.");
        }
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

    @Override
    public Iterator<HorizontalLine> iterator() {
        return lines.iterator();
    }

}
