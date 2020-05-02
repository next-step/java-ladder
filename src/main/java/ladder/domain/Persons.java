package ladder.domain;

import ladder.service.type.GameResult;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Persons {
    private List<Person> persons;

    private Persons(String[] personNames) {
        this.persons = Arrays.stream(personNames)
                .map(Person::getInstance)
                .collect(Collectors.toList());
    }

    private Persons(List<Person> persons) {
        this.persons = persons.stream()
                .map(Person::getNewInstance)
                .collect(Collectors.toList());
    }

    public static Persons getInstance(String[] personNames) {
        return new Persons(personNames);
    }

    public static Persons getInstance(List<Person> persons) {
        return new Persons(persons);
    }

    public List<String> getPersonNames() {
        return persons.stream()
                .map(Person::nameOf)
                .collect(Collectors.toList());
    }

    public int getCount() {
        return persons.size();
    }

    public GameResult getResultOfLadder(Ladder ladder) {
        GameResult gameResult = GameResult.getInstance();

        int countOfPerson = persons.size();
        for (int i = 0; i < countOfPerson; i++) {
//            String resultValue = ResultValue.valueOf(ladder.getLadderResult(i));
//            gameResult.put(Person.nameOf(persons.get(i)), resultValue);
        }

        return gameResult;
    }
}
