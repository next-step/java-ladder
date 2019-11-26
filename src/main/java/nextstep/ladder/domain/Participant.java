package nextstep.ladder.domain;

import java.util.List;
import java.util.Objects;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-26 12:23
 */
public class Participant {
    private final List<String> participant;

    public Participant(List<String> names) {
        this.participant = names;
    }

    public int numberOfParticipants() {
        return this.participant.size();
    }

    public List<String> getParticipant() {
        return participant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return Objects.equals(participant, that.participant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(participant);
    }
}
