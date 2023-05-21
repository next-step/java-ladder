package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import ladder.domain.request.LadderRequest;

public class Ladder {

    private final List<Line> lines;
    private final Participants participants;

    public Ladder(List<Line> lines, Participants participants) {
        this.lines = lines;
        this.participants = participants;
    }

    public List<Line> getLines() {
        return this.lines;
    }

    public static Ladder of(LadderRequest request, Participants participants) {
        List<Line> tempLines = new ArrayList<>();
        for (int i = 0; i <= request.getHeight(); i++) {
            tempLines.add(Line.from(request));
        }
        return new Ladder(tempLines, participants);
    }
}
