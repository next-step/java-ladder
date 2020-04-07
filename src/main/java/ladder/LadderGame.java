package ladder;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class LadderGame {
    private List<Line> ladder;

    public LadderGame(List<String> users, int ladderMaxHeight) {
        ladder = generateLadder(users.size(), ladderMaxHeight);
    }

    public List<Line> getLadder() {
        return Collections.unmodifiableList(ladder);
    }

    private List<Line> generateLadder(int countOfPerson, int ladderMaxHeight) {
        return Stream
                .generate(() -> new Line(countOfPerson))
                .limit(ladderMaxHeight)
                .collect(toList());
    }
}
