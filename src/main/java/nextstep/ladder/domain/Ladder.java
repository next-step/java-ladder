package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private final static int ZERO = 0;

    private final List<HorizontalLine> horizontalLines;

    public Ladder(List<Person> people, int heightOfLadder) {
        validatePeople(people);
        validateHeight(heightOfLadder);
        this.horizontalLines = IntStream.range(ZERO, heightOfLadder)
                .mapToObj(height -> HorizontalLine.createLineWithPoints(people.size()))
                .collect(Collectors.toList());
    }

    private void validatePeople(List<Person> people) {
        if (people == null || people.isEmpty()) {
            throw new IllegalArgumentException("사다리 타기에 참여할 사용자가 입력되지 않았습니다.");
        }

        if (people.size() < 2) {
            throw new IllegalArgumentException("사다리 게임에 참여하는 사람의 수는 최소 2명 이상이어야 합니다.");
        }
    }

    private void validateHeight(int heightOfLadder) {
        if (heightOfLadder < 1) {
            throw new IllegalArgumentException("사다리의 높이는 1이상이어야 합니다.");
        }
    }

    public List<HorizontalLine> horizontalLines() {
        return horizontalLines;
    }
}
