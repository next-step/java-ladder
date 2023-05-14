package nextstep.laddergame.domain.ladder;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

public class Line {
    private static final Random random = new Random();
    private final List<Position> positions;

    public Line(int participantCounts) {
        this.checkParticipantCounts(participantCounts);

        final List<Position> positionsList = new ArrayList<>();
        Direction direction = null;

        for (int i = 0; i < participantCounts; i++) {
            direction = this.makeDirection(direction, i, participantCounts - 1);
            positionsList.add(new Position(i, direction));
        }

        this.positions = positionsList;
    }

    private Direction makeDirection(Direction direction, int currentIndex, int lastIndex) {
        if (Objects.isNull(direction)) {
            return Direction.first(random.nextBoolean());
        }

        if (currentIndex == lastIndex) {
            return direction.last();
        }

        return direction.next(random.nextBoolean());
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
