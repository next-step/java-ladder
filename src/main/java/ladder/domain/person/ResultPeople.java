package ladder.domain.person;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ResultPeople {

    private final List<Person> resultPeople;

    public ResultPeople(List<Person> persons) {
        this.resultPeople = persons;
    }

    public List<Person> resultPeople() {
        return Collections.unmodifiableList(this.resultPeople);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultPeople that = (ResultPeople) o;
        return Objects.equals(resultPeople, that.resultPeople);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resultPeople);
    }
}
