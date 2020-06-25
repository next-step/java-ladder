package ladder.domain;

import ladder.util.StringUtil;

import java.util.*;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Persons {

    public static final String LADDER_GAME_MINIMUM_EXCEPTION = "사다리 게임은 최소 2인 이상이 진행 가능합니다.";

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

    public Map<String, String> prizeResult(Ladder ladder, Prizes prizes) {
        Map<String, String> result = new LinkedHashMap<>();
        int personIndex = 0;
        for (Person person : persons){
            int prizeIndex = ladder.getPrizeIndex(personIndex);
            result.put(person.getName(), prizes.getPrizeValue(prizeIndex));
            personIndex++;
        }
        return result;
    }
}
