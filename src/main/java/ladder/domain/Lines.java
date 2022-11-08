package ladder.domain;

import ladder.strategy.LineGenerateStrategy;

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

    public static Lines from(int linesSize, int lineSize, LineGenerateStrategy strategy) {
        List<LadderLine> result = new ArrayList<>();
        for (int i = 0; i < linesSize; i++) {
            result.add(LadderLine.init(lineSize));
        }
        return new Lines(result);
    }

    public Results getResult(Participants participants, ExpectedResults expectedResults) {
        Map<Participant, ExpectedResult> result = new LinkedHashMap<>();
        List<Participant> participantsForOrder = participants.getParticipants();
        for (int i = 0; i < participantsForOrder.size(); i++) {
            result.put(participantsForOrder.get(i), expectedResults.getByIndex(getEachResult(i)));
        }
        return new Results(result);
    }

    public int getEachResult(int participantOrder) {
        int result = participantOrder;
        for (LadderLine line : lines) {
            result = line.move(result);
        }
        return result;
    }
}
