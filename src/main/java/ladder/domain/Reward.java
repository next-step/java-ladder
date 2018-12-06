package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Reward {

    private static final String SEPARATOR = ",";

    private List<Benefit> benefits;

    private Reward(String line) {
        benefits = Arrays.asList(line.split(SEPARATOR))
                    .stream()
                    .map(Benefit::from)
                    .collect(Collectors.toList());
    }

    public static Reward from(String line) {
        return new Reward(line);
    }

    public List<Benefit> getRewards() {
        return benefits;
    }

    public Benefit findPersonResult(int position) {
        return benefits.get(position);
    }
}
