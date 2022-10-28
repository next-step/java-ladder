package ladder.domain;

import ladder.domain.person.Person;

import java.util.*;

public class ResultMap {

    private final Map<Person, Optional<String>> resultMap;

    public ResultMap(Person... persons) {
        this.resultMap = new HashMap<>();
        Arrays.stream(persons)
                .forEach(person -> resultMap.put(person,Optional.empty()));
    }
}
