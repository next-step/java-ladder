package ladder.domain.result;

import ladder.domain.person.Person;
import ladder.domain.person.ResultPeople;
import ladder.dto.LadderGameResultDto;
import ladder.exception.result.ResultNotExistException;

import java.util.*;
import java.util.stream.Collectors;

public class ResultMap {

    private final Map<Person, Optional<Result>> resultMap;

    public ResultMap(Person... persons) {
        this(Arrays.stream(persons)
                .collect(Collectors.toList()));
    }

    public ResultMap(ResultPeople resultPeople) {
        this(resultPeople.resultPeople());
    }

    public ResultMap(List<Person> persons) {
        this.resultMap = new HashMap<>();
        persons.forEach(person -> resultMap.put(person, Optional.empty()));
    }

    public void setPersonResult(Person person, Result result) {
        resultMap.put(person, Optional.of(result));
    }

    public Result result(Person person) {
        return resultMap.get(person)
                .orElseThrow(ResultNotExistException::new);
    }

    public void setResult(LadderGameResultDto ladderGameResultDto) {
        this.resultMap.keySet()
                .forEach(person -> {
                            Result result = ladderGameResultDto.results().result(ladderGameResultDto.ladderLines().result(person.getHorizontalPosition()));
                            this.setPersonResult(person, result);
                        }
                );
    }
}
