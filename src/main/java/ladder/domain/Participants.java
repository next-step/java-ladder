package ladder.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Participants {
    public static final String SEPARATOR = ",";

    private List<Person> participants;

    private Participants(String nameOfPerson) {
        this.participants = Arrays.stream(nameOfPerson.split(SEPARATOR))
                .map(name -> Person.of(name.trim()))
                .collect(Collectors.toList());
    }

    public static Participants valueOf(String nameOfPerson) {
        return new Participants(nameOfPerson);
    }

    public int size() {
        return participants.size();
    }

    public List<Person> getParticipants() {
        return Collections.unmodifiableList(participants);
    }

    public GameResult runLadder(Ladder ladder, Results results) {
        Map<Person, Result> gameResult = new HashMap<>();
        for (int personIndex = 0; personIndex < participants.size(); personIndex++) {
            int finalPoint = ladder.run(personIndex);
            Result result = results.find(finalPoint);
            gameResult.put(participants.get(personIndex), result);
        }
        return GameResult.valueOf(gameResult);
    }
}
