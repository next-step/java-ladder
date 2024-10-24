package step2.model;

import step2.ganerator.RandomGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private final static String MINIMUM_LADDER_COUNT_MESSAGE = "사다리의 높이는 2이상이여여만 합니다.";
    private final static String LADDER_SIZE_OVER_MAX_MESSAGE = "사다리의 너비 크기는 0미만 %s를 초과하면 안됩니다.";

    private final static int MINIMUM_LADDER_COUNT = 2;

    private List<Line> line = new ArrayList<>();

    public Ladder(Person person, int ladderSize, RandomGenerator randomGenerator) {
        confirmLadderCount(ladderSize);
        this.line = IntStream.rangeClosed(0, ladderSize - 1)
                .mapToObj(i -> Line.createLine(person, randomGenerator))
                .collect(Collectors.toList());
    }

    //사다리를 생성한다.
    public static Ladder createLadder(Person person, int ladderSize, RandomGenerator randomGenerator) {
        return new Ladder(person, ladderSize, randomGenerator);
    }

    //참여인원의 인덱스를 입력받아 사다리게임을 진행한다.
    public int[] startLadderGame(int[] personIndex) {
        return Arrays.stream(personIndex)
                .map(i -> {
                    confirmLadderSizeOverMax(i);
                    return this.line.stream()
                            .reduce(i, (index, line) -> line.getLineForward(index), (a, b) -> b);
                })
                .toArray();
    }

    public List<Line> getLine() {
        return line;
    }

    //생성하는 최대 사다리수를 체크한다.
    private void confirmLadderCount(int ladderSize) {
        if (ladderSize < MINIMUM_LADDER_COUNT) {
            throw new IllegalArgumentException(MINIMUM_LADDER_COUNT_MESSAGE);
        }
    }

    //입력받은 인덱스가 사다리 너비를 벗어나는지 체크한다.
    private void confirmLadderSizeOverMax(int i) {
        if (line.size() <= i || i < 0) {
            throw new IllegalArgumentException(String.format(LADDER_SIZE_OVER_MAX_MESSAGE, line.size()));
        }
    }

    @Override
    public String toString() {
        return "Ladder{" +
                "Line=" + line +
                '}';
    }

}
