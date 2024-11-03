package nextstep.ladder.domain;

import java.util.Map;

public class PersonResult {
    private final Map<Person, Result> personResult;

    public PersonResult(Person person, Result result) {
        this.personResult = Map.of(person, result);
    }

    public boolean isExist(String personName){
        return personResult.containsKey(new Person(personName));
    }

    public Result search(String personName) {
        return personResult.get(new Person(personName));
    }
}
