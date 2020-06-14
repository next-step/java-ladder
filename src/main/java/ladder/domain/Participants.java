package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static ladder.utils.LadderUtil.fillSpace;

public class Participants {
    public static final String SEPARATOR = ",";

    private List<Person> participants;

    private Participants(String nameOfPerson) {
        this.participants = Arrays.stream(nameOfPerson.split(SEPARATOR))
                .map(name -> Person.create(name.trim()))
                .collect(Collectors.toList());
    }

    public static Participants create(String nameOfPerson) {
        return new Participants(nameOfPerson);
    }

    public int tellCountOfPerson() {
        return participants.size();
    }

    public String tellParticipants() {
        String nameOfPerson = "";
        for (Person person : participants) {
            nameOfPerson += fillSpace(person.tellName());
        }
        return nameOfPerson;
    }

}
