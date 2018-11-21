package ladder.domain;

import ladder.domain.ladder.Ladder;
import ladder.domain.player.People;
import ladder.domain.player.Person;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderResult {

    private static final String delimiter = ",";
    private List<Result> results;
    private People people;

    public LadderResult(String resultString, People people) {
        results = Arrays.asList(resultString.split(delimiter))
                .stream()
                .map(result -> new Result(result))
                .collect(Collectors.toList());
        this.people = people;
    }

    public Result getResultForPerson(Person person, Ladder ladder) {
        return results.get(ladder.getResult(people.getCountForPerson(person)));

    }
}
