package ladder.domain.core.line;

import java.util.stream.Collectors;

import ladder.ui.result.DisplayResult;

public class ParticipantsLine implements Line {
    private final Participants participants;

    ParticipantsLine(Participants participants) {
        this.participants = participants;
    }

    public static ParticipantsLine of(String participants) {
        return new ParticipantsLine(Participants.of(participants));
    }

    public int getNumberOfParticipants(){
        return participants.getCount();
    }

    @Override
    public int indexOf(String name) {
        return participants.indexOf(name);
    }

    @Override
    public String getResult(int index) {
        return participants.get(index);
    }

    @Override
    public DisplayResult toDisplayResult() {
        return () -> participants.names()
                                 .stream()
                                 .map(n -> String.format("%6s",n))
                                 .collect(Collectors.joining(""));

    }
}
