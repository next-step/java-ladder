package nextstep.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Participants {
    List<Participant> participants = new ArrayList<Participant>();

    public Participants(String names) {
        this(Arrays.stream(convertNameSplit(names))
                .map(Participant::new)
                .collect(Collectors.toUnmodifiableList()));
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
}
