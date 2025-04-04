package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    public static final String INVALID_LADDER_HEIGHT_MESSAGE = "사다리 높이는 1 이상이어야 합니다.";
    private final List<LadderLine> ladderLines;
    private final Participants participants;

    public Ladder(int height, String[] names) {
        if (height < 1) {
            throw new IllegalArgumentException(INVALID_LADDER_HEIGHT_MESSAGE);
        }
        this.participants = new Participants(names);

        List<LadderLine> ladderLines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            ladderLines.add(LadderLine.generate(names.length - 1));
        }
        this.ladderLines = Collections.unmodifiableList(ladderLines);
    }

    public String[] getNames() {
        return participants.getNames().toArray(new String[0]);
    }

    public List<LadderLine> getLines() {
        return ladderLines;
    }
}
