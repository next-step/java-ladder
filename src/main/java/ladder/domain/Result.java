package ladder.domain;

import ladder.domain.ladder.ladderline.LadderLines;
import ladder.domain.person.Person;

import java.util.*;
import java.util.List;

public class Result {

    private final Map<Person, Reward> resultMap = new HashMap<>();

    public Result(LadderLines ladderLines, Rewards rewards, List<Person> personList) {
        personList.forEach(person -> resultMap.put(person, rewards.reward(ladderLines.result(person.position()))));
    }

    public Reward result(Person person) {
        return resultMap.get(person);
    }

    public Map<Person, Reward> resultMap() {
        return resultMap;
    }
}
