package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Rewards extends LadderStrings<Reward> {

    public Rewards(String names) {
        super(toList(names));
    }

    private static List<Reward> toList(String names) {
        if (Objects.isNull(names)) {
            throw new IllegalArgumentException(NULL_MESSAGE);
        }

        return Arrays.stream(names.split(DELIMITER))
                .map(Reward::new)
                .collect(Collectors.toList());
    }

}
