package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Reward {

    private static final String SEPARATOR = ",";

    private List<benefit> benefits;

    private Reward(String line) {
        benefits = Arrays.asList(line.split(SEPARATOR))
                    .stream()
                    .map(benefit::from)
                    .collect(Collectors.toList());
    }

    public static Reward from(String line) {
        return new Reward(line);
    }

    public List<benefit> getRewards() {
        return benefits;
    }

    public benefit findPersonResult(Position position) {
        return benefits.get(position.getPosition());
    }
}
