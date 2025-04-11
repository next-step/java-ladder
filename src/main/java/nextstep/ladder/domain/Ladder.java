package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Ladder {
    public static final String INVALID_LADDER_HEIGHT_MESSAGE = "사다리 높이는 1 이상이어야 합니다.";
    public static final String NO_MATCH_LADDER_SIZE_WITH_PARTICIPANTS = "사다리 라인의 크기는 (참여자 수 - 1) 이어야 합니다.";
    private final Participants participants;
    private final List<LadderLine> ladderLines;

    public Ladder(Participants participants, List<LadderLine> ladderLines) {
        this.validateLadderLines(participants, ladderLines);

        this.participants = participants;
        this.ladderLines = ladderLines;
    }

    private void validateLadderLines(Participants participants, List<LadderLine> ladderLines) {
        if (ladderLines.isEmpty()) {
            throw new IllegalArgumentException(INVALID_LADDER_HEIGHT_MESSAGE);
        }

        ladderLines.forEach(ladderLine -> {
            if (ladderLine.size() != calculateLadderLineSize(participants.size())) {
                throw new IllegalArgumentException(NO_MATCH_LADDER_SIZE_WITH_PARTICIPANTS + " - SIZE : " + ladderLine.size());
            }
        });
    }

    private static int calculateLadderLineSize(int ParticipantSize) {
        return ParticipantSize - 1;
    }

    public List<Participant> getNames() {
        return participants.getNames();
    }

    public List<LadderLine> getLines() {
        return ladderLines;
    }

    public static Ladder generate(int height, String[] names) {
        valid(height);
        Participants participants = new Participants(names);
        List<LadderLine> ladderLines = generateLines(height, names);
        return new Ladder(participants, ladderLines);
    }

    private static void valid(int height) {
        if (height < 1) {
            throw new IllegalArgumentException(INVALID_LADDER_HEIGHT_MESSAGE);
        }
    }

    private static List<LadderLine> generateLines(int height, String[] names) {
        int ladderLineSize = calculateLadderLineSize(names.length);
        List<LadderLine> ladderLines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            ladderLines.add(LadderLine.generate(ladderLineSize));
        }
        return Collections.unmodifiableList(ladderLines);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return Objects.equals(participants, ladder.participants) && Objects.equals(ladderLines, ladder.ladderLines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(participants, ladderLines);
    }
}
