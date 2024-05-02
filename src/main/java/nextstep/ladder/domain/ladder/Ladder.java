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

    public int move(int position) {
        int result = position;
        for (Line line : lines) {
            result = line.move(result);
        }
        return result;
    }

    public static Ladder of(List<Line> lines) {
        return new Ladder(lines);
    }

    public List<Line> getLines() {
        return lines;
    }

    public static Ladder generate(int userCount, int height) {
        return new Ladder(IntStream.range(0, height)
            .mapToObj(idx -> Line.generate(userCount))
            .collect(Collectors.toList()));
    }

    public UserResults createUserResults(Users users, LadderResult ladderResult) {
        return UserResults.of(IntStream.range(0, users.numberOfUsers())
            .mapToObj(idx-> UserResult.of(
                users.getUser(idx), ladderResult.getResult(move(idx))
                )
            )
            .collect(Collectors.toList()));
    }
}
