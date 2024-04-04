package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Participants {
    private final List<Participant> participants;

    public Participants(String names) {
        this(names.split(","));
    }

    public Participants(String[] names) {
        this(generateNames(names));
    }

    public Participants(List<Participant> participants) {
        if(participants.size() <= 1){
            throw new IllegalArgumentException();
        }
        this.participants = participants;
    }

    private static List<Participant> generateNames(String[] names){
        return Arrays.stream(names)
                .map(Participant::new)
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Participants)) return false;
        Participants that = (Participants) o;
        return Objects.equals(participants, that.participants);
    }

    @Override
    public int hashCode() {
        return Objects.hash(participants);
    }

    public int getSize(){
        return this.participants.size();
    }

    public List<Name> getName() {
        return this.participants.stream()
                .map(Participant::getName)
                .collect(Collectors.toList());
    }

    public Participants regenerate(int[] orders) {
        ArrayList<Participant> newParticipants = new ArrayList<>();
        for (int order : orders) {
            newParticipants.add(this.participants.get(order));
        }
        return new Participants(newParticipants);
    }
}
