package ladder;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class LadderGame {
    private List<String> users;
    private List<Line> ladder;

    public LadderGame(List<String> users, int ladderMaxHeight) {
        this.users = users;
        ladder = generateLadder(users.size(), ladderMaxHeight);
    }

    private List<Line> generateLadder(int countOfPerson, int ladderMaxHeight) {
        return Stream
                .generate(() -> new Line(countOfPerson))
                .limit(ladderMaxHeight)
                .collect(toList());
    }

    public List<Line> getLadder() {
        return Collections.unmodifiableList(ladder);
    }
}
