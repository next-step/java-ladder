package ladder.domain;

import ladder.domain.person.Person;
import ladder.exception.ResultNotExistException;

import java.util.*;

public class ResultMap {

    private final Map<Person, Optional<String>> resultMap;

    public ResultMap(Person... persons) {
        this.resultMap = new HashMap<>();
        Arrays.stream(persons)
                .forEach(person -> resultMap.put(person, Optional.empty()));
    }

    public void setPersonResult(Person person, String result) {
        resultMap.put(person, Optional.of(result));
    }

    public String result(Person person) {
        return resultMap.get(person)
                .orElseThrow(ResultNotExistException::new);
    }
}
