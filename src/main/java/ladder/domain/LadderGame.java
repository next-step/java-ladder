package ladder.domain;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import ladder.view.delegator.PrintType;

public class LadderGame {

    private static final String ALL = "all";
    private final Ladder ladder;

    private final Participants participants;

    private final LadderResultValue ladderResult;

    private Map<Integer, Participant> paritipantPosition;

    public LadderGame(Ladder ladder, Participants participants, LadderResultValue ladderResult) {
        this.ladder = ladder;
        this.participants = participants;
        this.ladderResult = ladderResult;
        this.paritipantPosition = IntStream.range(0, participants.getSize())
                .boxed()
                .collect(Collectors.toMap(
                                integer -> integer,
                                integer -> participants.getParticipants().get(integer)
                        )
                );
    }

    public List<Participant> getParticipants() {
        return participants.getParticipants();
    }

    public List<Line> getLines() {
        return ladder.getLines();
    }

    public List<LadderResult> getResults() {
        return ladderResult.getResults();
    }

    public PrintDelegator getParticipantPosition(Participant participant) {
        if (participant.getName().equals(ALL)) {
            return new PrintDelegator(
                    PrintType.ALL,
                    paritipantPosition.entrySet().stream()
                            .collect(Collectors.toMap(
                                    Entry::getValue,
                                    position -> ladderResult.getPosition(position.getKey())
                            )));

        }

        return new PrintDelegator(
                PrintType.SINGLE,
                paritipantPosition.entrySet().stream()
                        .filter(entry -> Objects.equals(entry.getValue(), participant))
                        .collect(Collectors.toMap(
                                Entry::getValue,
                                position -> ladderResult.getPosition(position.getKey())
                        )));

    }

    public void process() {
        for (Line line : ladder.getLines()) {
            iterateLine(line);
        }
    }

    private void iterateLine(Line line) {
        for (int i = 0; i <= line.getSize() - 1; i++) {
            ifHasLineChangePosition(line, i);
        }
    }

    private void ifHasLineChangePosition(Line line, int i) {
        Boolean hasLine = line.getPoints().get(i);
        if (hasLine) {
            Participant leftParticipant = paritipantPosition.get(i);
            Participant rightParticipant = paritipantPosition.get(i + 1);
            Participant tempParticipant = leftParticipant;
            leftParticipant = rightParticipant;
            rightParticipant = tempParticipant;

            paritipantPosition.put(i, leftParticipant);
            paritipantPosition.put(i + 1, rightParticipant);
        }
    }

}
