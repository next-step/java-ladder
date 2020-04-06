package ladder.domain;

import ladder.domain.ladder.LadderNo;

import java.util.Optional;

public class Gamer {
    private static final String INSTANTIATE_ERROR_FORMAT = "Create Gamer fail. name must be at least 1 character and 5 characters : name=%s";
    private final String name;
    private final LadderNo ladderNo;

    private Gamer(String name, LadderNo ladderNo) {
        this.name = name;
        this.ladderNo = ladderNo;
    }

    public static Gamer of(String name, int no) {
        return Optional.ofNullable(name)
                .map(String::trim)
                .filter(nameString -> nameString.length() <= 5)
                .filter(nameString -> !nameString.isEmpty())
                .map(name1 -> new Gamer(name1, LadderNo.of(no)))
                .orElseThrow(() -> new IllegalArgumentException(String.format(INSTANTIATE_ERROR_FORMAT, name)));
    }

    public String getName() {
        return name;
    }

    public LadderNo getLadderNo() {
        return ladderNo;
    }

    @Override
    public String toString() {
        return "Gamer{" +
                "name='" + name + '\'' +
                ", ladderNo=" + ladderNo +
                '}';
    }
}
