package com.fineroot.ladder.domain;

import com.fineroot.ladder.utils.RandomUtils;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ladder {

    private final List<Line> lineList;
    private final int userCount;

    private Ladder(final List<Line> lineList, final int userCount) {
        this.lineList = lineList;
        this.userCount = userCount;
    }

    public static Ladder of(final Users users, final int countOfHeight) {
        return new Ladder(Stream.generate(() -> Line.fromBooleanArray(
                        RandomUtils.getBooleanArray(users.size())))
                .limit(countOfHeight).collect(Collectors.toList()), users.size());
    }

    public static Ladder fromBooleanArrays(final Boolean[][] booleanArrays, final int userCount) {
        return new Ladder(Arrays.stream(booleanArrays)
                .map(Line::fromBooleanArray)
                .collect(Collectors.toList()), userCount);
    }

    public Position resultOne(final Position position) {
        return calculateResultPosition(position);
    }

    public List<Position> resultAll() {
        return IntStream.range(0, userCount)
                .mapToObj(i -> calculateResultPosition(new Position(i)))
                .collect(Collectors.toList());
    }

    private Position calculateResultPosition(final Position position) {
        return lineList.stream()
                .reduce(position, (result, line) -> line.move(result), (a, b) -> b);
    }

    public String toStringBoard(final int firstUsernameLength) {
        return lineList.stream()
                .map(e -> " ".repeat(firstUsernameLength).concat(e.toString().concat(System.lineSeparator())))
                .collect(Collectors.joining());
    }
}
