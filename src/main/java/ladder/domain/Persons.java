package ladder.domain;

import ladder.util.StringUtil;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Persons {

    public static final String LADDER_GAME_MINIMUM_EXCEPTION = "사다리 게임은 최소 2인 이상이 진행 가능합니다.";

    private static final String PERSON_NAME_FORMAT = "%6s";

    private static final int LADDER_GAME_MINIMUM_PLAYER = 2;

    private final List<Person> persons;

    private Persons(List<Person> persons) {
        checkCountPerson(persons);
        this.persons = persons;
    }

    public static Persons of(String persons){
        return Arrays.stream(StringUtil.split(persons))
                     .map(Person::of)
                     .collect(collectingAndThen(toList(), Persons::new));
    }

    private static void checkCountPerson(List<Person> persons) {
        if (persons.size() < LADDER_GAME_MINIMUM_PLAYER){
            throw new IllegalArgumentException(LADDER_GAME_MINIMUM_EXCEPTION);
        }
    }

    public int count() {
        return persons.size();
    }

    public List<Person> getPersons() {
        return Collections.unmodifiableList(persons);
    }

    public String getPersonName(int position){
        return persons.get(position).getName();
    }

    private static String formatWord(String name) {
        return String.format(PERSON_NAME_FORMAT, name);
    }

    @Override
    public String toString() {
        return persons.stream()
                      .map(person -> formatWord(person.getName()))
                      .collect(Collectors.joining());
    }
}
