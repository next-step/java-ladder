package ladder.domain.ladder;

import ladder.domain.user.Name;
import ladder.domain.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private static final int MIN_HEIGHT = 1;
    private List<User> users = new ArrayList<>();
    private List<FootStep> footSteps = new ArrayList<>();

    private Ladder(int height, List<String> names) {
        validate(height);
        createUsers(names);
        createFootSteps(height);
    }

    private void createUsers(List<String> names) {
        names.forEach(name -> users.add(User.of(Name.of(name.trim()))));
    }

    private void createFootSteps(int height) {
        IntStream.range(0, height)
                .forEach(i -> this.footSteps.add(FootStep.of(getCountOfUsers())));
    }

    private void validate(int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException("사다리의 높이는 " + MIN_HEIGHT + "이상의 값이어야 합니다.");
        }
    }

    public static Ladder of(int height, List<String> names) {
        return new Ladder(height, names);
    }

    public int getFootStepSize() {
        return footSteps.size();
    }

    public int getCountOfUsers() {
        return users.size();
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(this.users.stream()
                        .map(User::toString)
                        .collect(Collectors.joining()))
                .append("\n")
                .append(this.footSteps.stream()
                        .map(FootStep::toString)
                        .collect(Collectors.joining("\n"))).toString();
    }
}
