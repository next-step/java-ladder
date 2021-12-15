package ladder.domain;


import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Participants {
    private final List<Participant> participants;

    public Participants(String text) {
        this(text.split(","));
    }

    public Participants(String[] names) {
        this(IntStream.range(0, names.length)
                .mapToObj(i -> new Participant(names[i], i + 1, 1))
                .collect(Collectors.toList()));
    }

    public Participants(List<Participant> participants) {
        this.participants = participants;
    }

    public int size() {
        return this.participants.size();
    }

    public List<Participant> getParticipants() {
        return Collections.unmodifiableList(this.participants);
    }

    public List<String> getParticipantNames() {
        return Collections.unmodifiableList(this.participants.stream()
                .map(Participant::getName)
                .collect(Collectors.toList()));
    }

    public Participants playOneFloor(int height, Floor floor) {
        return new Participants(participants.stream()
                .map(
                        participant -> {
                            int newPosition = floor.whichDirection(participant.getSection());
                            return new Participant(participant.getName(),
                                    newPosition,
                                    height + 1);
                        })
                .collect(Collectors.toList()));
    }

    public void print() {
        participants.forEach(System.out::println);
    }

    public int getParticipantSection(String name) {
        Participant participant = participants.stream().filter(p -> p.getName().equals(name))
                .findFirst().orElseThrow(
                        () -> new IllegalArgumentException("해당 이름의 참가자가 없습니다.")
                );
        return participant.getSection();
    }

}
