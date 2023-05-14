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
        Direction direction = Direction.first(random.nextBoolean());

        for (int i = 0; i < participantCounts; i++) {
            positionsList.add(new Position(i, direction));
            direction = direction.next(random.nextBoolean());
        }

        this.positions = positionsList;
    }

    private void checkParticipantCounts(int participantCounts) {
        if (participantCounts == 0) {
            throw new IllegalArgumentException("참여자 수는 한 명 이상이어야합니다.");
        }
    }

    public List<Boolean> getLineToPrint() {
        return this.positions
                .stream()
                .map(Position::isRightDirection)
                .collect(Collectors.toList());
    }
}
