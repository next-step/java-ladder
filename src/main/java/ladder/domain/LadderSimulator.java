package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import ladder.exception.LadderSimulatorInvalidException;

public class LadderSimulator {
    private final Ladder ladder;
    private final List<User> users;
    private final List<String> results;

    public LadderSimulator(Ladder ladder, List<User> users, List<String> results) {
        validate(users, results);

        this.ladder = ladder;
        this.users = users;
        this.results = results;
    }

    private void validate(List<User> users, List<String> results) {
        if (users == null || results == null) {
            throw new LadderSimulatorInvalidException();
        }

        if (users.size() != results.size()) {
            throw new LadderSimulatorInvalidException();
        }
    }

    public LadderResult getResults() {
        List<UserResult> userResults = IntStream.range(0, users.size())
            .mapToObj(this::simulate)
            .collect(Collectors.toList());

        return new LadderResult(userResults);
    }

    private UserResult simulate(int initialIndex) {
        int currentIndex = initialIndex;

        for (Line line : ladder.getLines()) {
            currentIndex = currentIndex + line.getMove(currentIndex);;
        }

        return new UserResult(initialIndex, users.get(initialIndex).getName(), results.get(currentIndex));
    }
}
