package ladder2.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Participants {
    private static final String SPLIT_DELIMITER = ",";
    private List<Participant> participants;

    private Participants(List<String> names) {
        this.participants = names.stream()
                .map(name -> Participant.from(name))
                .collect(Collectors.toList());
    }

    public static Participants fromComma(String names) {
        return new Participants(Arrays.asList(names.replaceAll(" ", "").split(SPLIT_DELIMITER)));
    }

    public int size() {
        return participants.size();
    }

    public Participant match(int index) {
        return participants.get(index);
    }

    public List<Participant> getParticipants() {
        return Collections.unmodifiableList(participants);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participants that = (Participants) o;
        return Objects.equals(participants, that.participants);
    }

    @Override
    public int hashCode() {
        return Objects.hash(participants);
    }
}
