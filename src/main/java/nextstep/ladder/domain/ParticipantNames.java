package nextstep.ladder.domain;

import java.util.List;

public class ParticipantNames {
    private final List<ParticipantName> names;

    public ParticipantNames(List<ParticipantName> names) {
        this.names = names;
    }

    public List<ParticipantName> getNames() {
        return names;
    }

    public int getFirstParticipantNameLength() {
        return names.stream()
                .findFirst()
                .map(name -> name.getName().length())
                .orElse(0);
    }

    public int size() {
        return names.size();
    }
}
