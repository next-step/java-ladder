package nextstep.ladder.domain.line;

import nextstep.ladder.domain.participant.Participants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lines {
    private List<Line> lineList = new ArrayList<>();

    public Lines() {}

    public void addLine(Line line) {
        lineList.add(line);
    }

    public void moveParticipants(Participants participants) {
        lineList.stream()
                .forEachOrdered(line -> line.movableParticipants(participants));
    }

    public final List<Line> getLineList() {
        return Collections.unmodifiableList(lineList);
    }
}
