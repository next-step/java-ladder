package ladder.domain;

import ladder.domain.person.Person;
import ladder.dto.LadderGameResultDto;

import java.util.*;
import java.util.List;

public class Result {

    private final Map<Person, LadderTextInput> resultMap = new HashMap<>();

    public Result(LadderGameResultDto ladderGameResultDto, List<Person> personList) {
        personList.forEach(person -> {
            LadderTextInput result = ladderGameResultDto.results()
                    .reward(ladderGameResultDto.ladderLines().result(person.position()));
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
