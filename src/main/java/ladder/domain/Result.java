package ladder.domain;

import ladder.domain.person.Person;
import ladder.dto.LadderGameResultDto;

import java.util.*;

public class Result {

    private final Map<Person, LadderTextInput> resultMap = new HashMap<>();

    public Result(LadderGameResultDto ladderGameResultDto, List<Person> personList) {
        personList.forEach(person -> {
            LadderTextInput result = ladderGameResultDto.results()
                    .result(ladderGameResultDto.ladderLines().result(person.getHorizontalPosition()));
            resultMap.put(person, result);
        });
    }

    public LadderTextInput result(Person person) {
        return resultMap.get(person);
    }

    public Map<Person, LadderTextInput> resultMap() {
        return resultMap;
    }
}
