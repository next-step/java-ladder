package com.jaeyeonling.ladder.view.format;

import com.jaeyeonling.ladder.domain.ladder.LadderGame;
import com.jaeyeonling.ladder.domain.ladder.LadderResult;
import com.jaeyeonling.ladder.domain.ladder.LadderResults;
import com.jaeyeonling.ladder.domain.line.Line;
import com.jaeyeonling.ladder.domain.line.Lines;
import com.jaeyeonling.ladder.domain.point.Direction;
import com.jaeyeonling.ladder.domain.user.User;
import com.jaeyeonling.ladder.domain.user.Username;
import com.jaeyeonling.ladder.domain.user.Users;

public final class Formatters {

    private Formatters() { }

    private static final Formatter<Username> usernameFormatter = new UsernameFormatter();
    private static final Formatter<User> userFormatter = UserFormatter.withUsernameFormatter(usernameFormatter);
    public static final Formatter<Users> usersFormatter = UsersFormatter.withUserFormatter(userFormatter);

    private static final Formatter<Direction> directionFormatter = new DirectionFormatter();
    private static final Formatter<Line> lineFormatter = LineFormatter.withDirectionFormatter(directionFormatter);
    private static final Formatter<Lines> linesFormatter = LinesFormatter.withLineFormatter(lineFormatter);
    public static final Formatter<LadderGame> ladderGameFormatter =
            LadderGameFormatter.withLinesFormatter(linesFormatter);

    public static final Formatter<LadderResult> ladderResultFormatter = new LadderResultFormatter();
    public static final Formatter<LadderResults> ladderResultsFormatter =
            LadderResultsFormatter.withLadderResultFormatter(ladderResultFormatter);

}
