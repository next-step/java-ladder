package ladder.domain;

import ladder.domain.ladder.LadderNumber;

import java.util.Optional;

public class Gamer {
    private static final String INSTANTIATE_ERROR_FORMAT = "Create Gamer fail. name must be at least 1 character and 5 characters : name=%s";
    private final String name;
    private final LadderNumber ladderNumber;

    private Gamer(String name, LadderNumber ladderNumber) {
        this.name = name;
        this.ladderNumber = ladderNumber;
    }

    public static Gamer of(String name, int no) {
        return Optional.ofNullable(name)
                .map(String::trim)
                .filter(nameString -> nameString.length() <= 5)
                .filter(nameString -> !nameString.isEmpty())
                .map(nameString -> new Gamer(nameString, LadderNumber.of(no)))
                .orElseThrow(() -> new IllegalArgumentException(String.format(INSTANTIATE_ERROR_FORMAT, name)));
    }

    public String getName() {
        return name;
    }

    public LadderNumber getLadderNumber() {
        return ladderNumber;
    }

    @Override
    public String toString() {
        return "Gamer{" +
                "name='" + name + '\'' +
                ", ladderNo=" + ladderNumber +
                '}';
    }
}
