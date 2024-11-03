package nextstep.ladder.domain;

import java.util.Objects;

public class PersonResult {
    private final Person person;
    private final Result result;

    public PersonResult(Person person, Result result) {

        this.person = person;
        this.result = result;
    }

    public boolean isExist(String personName) {
        return person.equals(new Person(personName));
    }

    public Person getPerson() {
        return person;
    }

    public Result getResult() {
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonResult that = (PersonResult) o;
        return Objects.equals(person, that.person) && Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person, result);
    }

}
