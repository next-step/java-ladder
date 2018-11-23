package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Result {

    private static final String SEPARATOR = ",";
    private List<Reward> rewards;

    private Result(String line) {
        rewards = Arrays.asList(line.split(SEPARATOR))
                    .stream()
                    .map(Reward::from)
                    .collect(Collectors.toList());
    }

    public static Result from(String line) {
        return new Result(line);
    }

    public List<Reward> getRewards() {
        return rewards;
    }

    public Reward findPersonResult(Position position) {
        return rewards.get(position.getPosition());
    }
}
