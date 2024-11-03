package nextstep.ladder.domain;

import java.util.Map;
import java.util.Objects;

public class PersonResult {
    private final Map<Person, Result> personResult;

    public PersonResult(Person person, Result result) {
        this.personResult = Map.of(person, result);
    }

    public boolean isExist(String personName){
        return personResult.containsKey(new Person(personName));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonResult that = (PersonResult) o;
        return Objects.equals(personResult, that.personResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personResult);
    }
}
