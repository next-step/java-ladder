package ladder.domain;

import ladder.domain.ladder.ladderline.LadderLines;
import ladder.domain.person.Person;
import ladder.dto.LadderGameResultDto;

import java.util.*;
import java.util.List;

public class Result {

    private final Map<Person, Reward> resultMap = new HashMap<>();

    public Result(LadderGameResultDto ladderGameResultDto, List<Person> personList) {
        personList.forEach(person -> {
            LadderLines ladderLines = ladderGameResultDto.ladderLines();
            Rewards results = ladderGameResultDto.results();

            resultMap.put(person, results.reward(ladderLines.result(person.position())));
        });
    }

    public Reward result(Person person) {
        return resultMap.get(person);
    }

    public Map<Person, Reward> resultMap() {
        return resultMap;
    }
}
