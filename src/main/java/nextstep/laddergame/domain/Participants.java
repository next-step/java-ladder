package nextstep.laddergame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        for (int index = 0; index < splitNames.length; index++) {
            participants.add(Person.of(splitNames[index], index));
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

    public Person findResultByNameAndLadder(String name, Ladder ladder) {
        Person person = findPerson(name);
        person.runLadder(ladder);
        return person;
    }

    private Person findPerson(String name) {
        return this.participants.stream()
                .filter(person -> person.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자를 찾을 수 없습니다."));
    }

    public List<Person> getAllResult(Ladder ladder) {
        for (Person participant : this.participants) {
            participant.runLadder(ladder);
        }
        return this.participants;
    }
}
