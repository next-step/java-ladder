package step2.domain;

import step2.util.StringUtil;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Persons {
    private static final int LADDER_GAME_MINIMUM_PLAYER = 2;
    private static final String LADDER_GAME_MINIMUM_EXCEPTION = "사다리 게임은 최소 2인 이상이 진행 가능합니다.";
    private final List<Person> persons;

    private Persons(List<Person> persons) {
        this.persons = persons;
    }

    public static Persons of(String persons){
        return Arrays.asList(StringUtil.split(persons))
                     .stream()
                     .map(Person::of)
                     .collect(collectingAndThen(toList(), Persons::convertObject));
    }

    private static Persons convertObject(List<Person> persons){
        checkCountPerson(persons.size());
        return new Persons(persons);
    }

    private static void checkCountPerson(int countOfperson) {
        if (countOfperson < LADDER_GAME_MINIMUM_PLAYER){
            throw new IllegalArgumentException(LADDER_GAME_MINIMUM_EXCEPTION);
        }
    }

    public int count() {
        return persons.size();
    }

    public List<Person> getPersons() {
        return persons;
    }
}
