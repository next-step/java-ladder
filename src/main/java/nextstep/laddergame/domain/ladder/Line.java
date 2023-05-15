package nextstep.laddergame.domain.ladder;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Line {
    private static final Random random = new Random();
    private final List<Position> positions;

    public Line(int participantCounts) {
        this.checkParticipantCounts(participantCounts);

        final List<Position> positionsList = new ArrayList<>();

        for (int i = 0; i < participantCounts; i++) {
            positionsList.add(this.makePosition(i, participantCounts - 1, positionsList));
        }

        this.positions = positionsList;
    }

    private Position makePosition(int currentIndex, int lastIndex, List<Position> positionsList) {
        if (currentIndex == 0) {
            return Position.first(random.nextBoolean());
        }

        final Position beforePosition = positionsList.get(currentIndex - 1);

        if (currentIndex == lastIndex) {
            return beforePosition.last(currentIndex);
        }

        return beforePosition.next(currentIndex, random.nextBoolean());
    }


    private void checkParticipantCounts(int participantCounts) {
        if (participantCounts == 0) {
            throw new IllegalArgumentException("참여자 수는 한 명 이상이어야합니다.");
        }
    }

    public int nextIndex(int currentIndex) {
        return this.positions.get(currentIndex)
                .moveResult();
    }

    public List<Boolean> getLineToPrint() {
        return this.positions
                .stream()
                .map(Position::isLeftDirection)
                .collect(Collectors.toList());
    }
}
