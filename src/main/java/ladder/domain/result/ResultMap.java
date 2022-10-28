package ladder.domain.result;

import ladder.domain.person.Person;
import ladder.exception.result.ResultNotExistException;

import java.util.*;
import java.util.stream.Collectors;

public class ResultMap {

    private final Map<Person, Optional<Result>> resultMap;

    public ResultMap(Person... persons) {
        this(Arrays.stream(persons).collect(Collectors.toList()));
    }

    public ResultMap(List<Person> persons) {
        this.resultMap = new HashMap<>();
        persons.forEach(person -> resultMap.put(person, Optional.empty()));
    }

    public void setPersonResult(Person person, String result) {
        resultMap.put(person, Optional.of(new Result(result)));
    }

    public void setPersonResult(Person person, Result result) {
        resultMap.put(person, Optional.of(result));
    }

    public Result result(Person person) {
        return resultMap.get(person)
                .orElseThrow(ResultNotExistException::new);
    }

}
