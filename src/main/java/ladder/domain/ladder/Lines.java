package ladder.domain.ladder;

import ladder.domain.result.ExpectedResult;
import ladder.domain.result.ExpectedResults;
import ladder.domain.result.Results;
import ladder.domain.user.Participant;
import ladder.domain.user.Participants;

import java.util.*;

public class Lines {
    private final List<LadderLine> lines;

    public Lines(List<LadderLine> lines) {
        this.lines = lines;
    }

    public Lines(LadderLine... lines) {
        this(Arrays.asList(lines));
    }

    public List<LadderLine> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public static Lines from(int linesSize, int lineSize) {
        List<LadderLine> result = new ArrayList<>();
        for (int i = 0; i < linesSize; i++) {
            result.add(LadderLine.init(lineSize));
        }
        return new Lines(Collections.unmodifiableList(result));
    }

    public Results getResult(Participants participants, ExpectedResults expectedResults) {
        Map<Participant, ExpectedResult> result = new LinkedHashMap<>();
        List<Participant> participantsForOrder = participants.getParticipants();
        for (int i = 0; i < participantsForOrder.size(); i++) {
            result.put(participantsForOrder.get(i), expectedResults.getByIndex(getEachResult(i)));
        }
        return new Results(Collections.unmodifiableMap(result));
    }

    public int getEachResult(int participantOrder) {
        int result = participantOrder;
        for (LadderLine line : lines) {
            result = line.move(result);
        }
        return result;
    }
}
