package ladder.domain;

import ladder.util.StringUtil;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Persons {
    public static final String LADDER_GAME_MINIMUM_EXCEPTION = "사다리 게임은 최소 2인 이상이 진행 가능합니다.";
    public static final String PERSONS_NULL_EXCEPTION = "참여자를 빈값으로 입력할 수 없습니다.";

    private static final int LADDER_GAME_MINIMUM_PLAYER = 2;

    private final List<Person> persons;

    private Persons(List<Person> persons) {
        checkCountPerson(persons);
        this.persons = persons;
    }

    public static Persons of(String persons){
        validatePersonsNull(persons);
        return Arrays.stream(StringUtil.split(persons))
                     .map(Person::of)
                     .collect(collectingAndThen(toList(), Persons::new));
    }

    private static void validatePersonsNull(String persons) {
        if (Objects.isNull(persons) || persons.isEmpty()){
            throw new IllegalArgumentException(PERSONS_NULL_EXCEPTION);
        }
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
}
