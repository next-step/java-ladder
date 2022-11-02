package ladder.view;

import java.util.List;

import ladder.domain.Line;
import ladder.domain.Users;

public class DisplayerFactory {
    public static Displayer createUserDisplayer(final Users users, final int displaySize) {
        return new UserDisplayer(users, displaySize);
    }

    public static Displayer createLineDisplayer(final List<Line> lines, final int displaySize) {
        return new LineDisplayer(lines, displaySize);
    }

    public static Displayer createResultDisplayer(final List<String> result, final int displaySize) {
        return new ResultDisplayer(result, displaySize);
    }
}
