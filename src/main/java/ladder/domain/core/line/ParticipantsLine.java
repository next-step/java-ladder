package ladder.domain.core.line;

import ladder.ui.result.DisplayResult;
import ladder.ui.result.NamesDisplayResult;

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
        return new NamesDisplayResult(participants.names());
    }
}
