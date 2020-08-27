package ladder.domain.core.line.name;

import ladder.domain.core.line.Line;
import ladder.ui.result.DisplayResult;
import ladder.ui.result.NamesDisplayResult;

public class ParticipantsLine implements Line {

    private final Names names;

    ParticipantsLine(Names names) {
        this.names = names;
    }

    public static ParticipantsLine of(String participants) {
        return new ParticipantsLine(Names.ofParticipants(participants));
    }

    @Override
    public int indexOf(String name) {
        return names.indexOf(new Name(name));
    }

    @Override
    public String getResult(int index) {
        return names.get(index);
    }

    @Override
    public int getWidth() {
        return names.getCount();
    }

    @Override
    public Names getNames() {
        return names;
    }

    @Override
    public DisplayResult toDisplayResult() {
        return new NamesDisplayResult(names);
    }
}
