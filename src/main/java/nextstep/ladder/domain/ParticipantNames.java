package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;

public class ParticipantNames {
    private final List<ParticipantName> names;

    public ParticipantNames(List<ParticipantName> names) {
        this.names = names;
    }

    public List<ParticipantName> getNames() {
        return Collections.unmodifiableList(names);
    }

    public int size() {
        return names.size();
    }
}
