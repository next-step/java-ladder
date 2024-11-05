package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class PersonResults {
    private final Map<Person, Result> personResultMap;

    public PersonResults(Map<Person, Result> personResultMap) {
        this.personResultMap = personResultMap;
    }

    public Result getResultByPerson(Person person) {
        return Optional.ofNullable(personResultMap.get(person))
                .stream()
                .findFirst()
                .orElseThrow(
                        () -> new IllegalArgumentException("만족하는 이름을 찾을 수 없습니다")
                );
    }

    public List<Person> getKeys() {
        return new ArrayList<>(personResultMap.keySet());
    }
}
