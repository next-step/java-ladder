package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {

    private static final int MIN_LADDER_HEIGHT = 1;

    private final Participants participants;
    private final List<Line> lineList;

    public LadderGame(Participants participants, int ladderHeight) {
        this(participants, generateLineList(participants, ladderHeight));
    }

    private LadderGame(Participants participants, List<Line> lineList) {
        this.participants = participants;
        this.lineList = lineList;
    }

    private static List<Line> generateLineList(Participants participants, int ladderHeight) {
        validate(participants, ladderHeight);
        return IntStream.range(0, ladderHeight)
                .mapToObj(i -> new Line(participants.getCount()))
                .collect(Collectors.toList());
    }

    private static void validate(Participants participants, int ladderHeight) {
        if (participants == null) {
            throw new IllegalArgumentException("참가자 정보를 입력해 주세요.");
        }
        if (ladderHeight < MIN_LADDER_HEIGHT) {
            throw new IllegalArgumentException("사다리의 높이는 최소 " + MIN_LADDER_HEIGHT + " 이상이어야 합니다.");
        }
    }

    public Participants getParticipants() {
        return participants;
    }

    public List<Line> getLineList() {
        return lineList;
    }
}
