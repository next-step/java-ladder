package nextstep.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Participants {
    List<Participant> participants = new ArrayList<Participant>();

    public Participants(String names) {
        this(createParticipants(convertNameSplit(names)));
    }

    private static List<Participant> createParticipants(String[] nameSplit) {
        List<Participant> participantList = IntStream.range(0, nameSplit.length)
                .mapToObj(i -> new Participant(nameSplit[i], i))
                .collect(Collectors.toUnmodifiableList());
        return participantList;
    }

    private static String[] convertNameSplit(String names) {
        return names.split(",");
    }

    public Participants(List<Participant> participants) {
        this.participants = participants;
    }

    public List<Participant> getList() {
        return this.participants;
    }

    public List<String> getNames() {
        return this.participants.stream().map(Participant::getName)
                .collect(Collectors.toUnmodifiableList());
    }

    public int countOfPerson() {
        return this.participants.size();
    }

    public void move(Lines lines) {
        List<Line> lineList = lines.getLineList();
        lineList.forEach(this::move);
    }

    public void move(Line line) {
        this.participants.forEach(participant -> participant.move(line));
    }
}
