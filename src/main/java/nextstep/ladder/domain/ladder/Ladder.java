package nextstep.ladder.domain.ladder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import nextstep.ladder.domain.result.LadderResult;
import nextstep.ladder.domain.result.UserResult;
import nextstep.ladder.domain.result.UserResults;
import nextstep.ladder.domain.user.Users;

public class Ladder {

    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(List<Line> lines) {
        return new Ladder(lines);
    }

    public List<Line> getLines() {
        return lines;
    }

    public static Ladder generateLadder(int userCount, int height) {
        return Ladder.of(IntStream.range(0, height)
            .mapToObj(idx -> Line.generateLine(userCount))
            .collect(Collectors.toList()));
    }

    private int findFinalIndex(int startIndex) {
        return lines.stream()
            .reduce(startIndex, (index, line) -> index + line.move(index), Integer::sum);
    }

    public UserResults createUserResults(Users users, LadderResult ladderResult) {
        return UserResults.of(IntStream.range(0, users.numberOfUsers())
            .mapToObj(idx-> UserResult.of(
                users.getUser(idx), ladderResult.getResult(findFinalIndex(idx))
                )
            )
            .collect(Collectors.toList()));
    }

    public int size() {
        return this.lines.size();
    }
}
