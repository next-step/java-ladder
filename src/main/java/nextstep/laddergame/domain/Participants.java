package nextstep.laddergame.domain;

import java.util.ArrayList;
import java.util.List;

public class Participants {
    private static final int MIN_PEOPLE_COUNT = 2;
    private final List<Person> participants;

    public Participants(List<Person> participants) {
        this.participants = participants;
    }

    public static Participants create(String names) {
        String[] splitNames = split(names);
        if (isLessThanTwo(splitNames)) {
            throw new IllegalArgumentException("최소 두명의 사람이 필요합니다");
        }

        List<Person> participants = new ArrayList<>();
        for (String name : splitNames) {
            participants.add(Person.from(name));
        }

        return new Participants(participants);
    }

    private static boolean isLessThanTwo(String[] splitNames) {
        return splitNames.length < MIN_PEOPLE_COUNT;
    }

    private static String[] split(String names) {
        return names.split(",");
    }

    public int getParticipantCount() {
        return participants.size();
    }

    public List<Person> getParticipants() {
        return participants;
    }
}
