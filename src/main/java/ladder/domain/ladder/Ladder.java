package ladder.domain.ladder;

import ladder.domain.user.LadderUsers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private static final int MIN_HEIGHT = 1;
    private final LadderUsers users;
    private List<FootStep> footSteps = new ArrayList<>();

    private Ladder(int height, LadderUsers users) {
        validate(height);
        this.users = users;
        createFootSteps(height);
    }

    private void createFootSteps(int height) {
        IntStream.range(0, height)
                .forEach(i -> this.footSteps.add(FootStep.of(this.users.getCountOfUsers())));
    }

    private void validate(int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException("사다리의 높이는 " + MIN_HEIGHT + "이상의 값이어야 합니다.");
        }
    }

    public static Ladder of(int height, LadderUsers users) {
        return new Ladder(height, users);
    }

    public int getFootStepSize() {
        return footSteps.size();
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(this.users.toString())
                .append("\n")
                .append(this.footSteps.stream()
                        .map(FootStep::toString)
                        .collect(Collectors.joining("\n"))).toString();
    }
}
