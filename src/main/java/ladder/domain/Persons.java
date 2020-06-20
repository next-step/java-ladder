package ladder.domain;

import ladder.util.StringUtil;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Persons {
    private static final int LADDER_GAME_MINIMUM_PLAYER = 2;
    private static final String PERSONS_NULL_EXCEPTION = "참여자를 빈값으로 입력할 수 없습니다.";
    public static final String LADDER_GAME_MINIMUM_EXCEPTION = "사다리 게임은 최소 2인 이상이 진행 가능합니다.";

    private final List<Person> persons;

    private Persons(List<Person> persons) {
        checkCountPerson(persons.size());
        this.persons = persons;
    }

    public static Persons of(String persons){
        validatePersonsNull(persons);
        return Arrays.asList(StringUtil.split(persons))
                     .stream()
                     .map(Person::of)
                     .collect(collectingAndThen(toList(), Persons::convertObject));
    }

    private static void validatePersonsNull(String Persons) {
        if (Objects.isNull(Persons) || Persons.isEmpty()){
            throw new IllegalArgumentException(PERSONS_NULL_EXCEPTION);
        }
    }

    private static Persons convertObject(List<Person> persons){
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
        return Collections.unmodifiableList(persons);
    }
}
