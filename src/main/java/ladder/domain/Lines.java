package ladder.domain;

import ladder.strategy.LineGenerateStrategy;

import java.util.*;

public class Lines {
    private final List<Line> lines;

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public Lines(Line... lines){
        this(Arrays.asList(lines));
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public static Lines from(int linesSize, int lineSize, LineGenerateStrategy strategy) {
        List<Line> result = new ArrayList<>();
        for (int i = 0; i < linesSize; i++) {
            result.add(Line.from(lineSize, strategy));
        }
        return new Lines(result);
    }

    public Results getResult(Participants participants, ExpectedResults expectedResults){
        Map<Participant, ExpectedResult> result = new LinkedHashMap<>();
        List<Participant> participantsForOrder = participants.getParticipants();
        for(int i = 0; i < participantsForOrder.size(); i++) {
            result.put(participantsForOrder.get(i), expectedResults.getByIndex(getEachResult(i)));
        }
        return new Results(result);
    }

    public int getEachResult(int participantOrder){
        Integer index = participantOrder;
        for (Line line : lines) {
            if(line.isLastPoint(index)) {
                if(line.getPoint(index)) index--;
                continue;
            }
            if(line.getPoint(index+1)) {
                index++;
                continue;
            }
            if(line.getPoint(index)) index--;
        }
        return index;
    }
}
