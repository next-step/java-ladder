package nextstep.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private List<Integer> results;

    public Ladder(Lines lines, int userCount) {
        this.results = play(lines, userCount);
    }

    private List<Integer> play(Lines lines, int userCount) {
        return IntStream.range(0, userCount)
                .map(lines::findDestination)
                .boxed()
                .collect(Collectors.toList());
    }

    public int getResult(Username username, Usernames usernames) {
        return results.get(usernames.getUsernameIndex(username));
    }

    public List<Integer> getResults() {
        return results;
    }
}
