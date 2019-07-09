package com.jaeyeonling.ladder.view.format;

import com.jaeyeonling.ladder.domain.ladder.LadderReword;
import com.jaeyeonling.ladder.domain.line.Line;
import com.jaeyeonling.ladder.domain.point.Direction;
import com.jaeyeonling.ladder.domain.user.User;
import com.jaeyeonling.ladder.domain.user.Username;
import com.jaeyeonling.ladder.domain.user.Users;

public class FormatterSupport {

    protected static final Formatter<Username> usernameFormatter = new UsernameFormatter();
    protected static final Formatter<User> userFormatter = UserFormatter.withUsernameFormatter(usernameFormatter);
    protected static final Formatter<Users> usersFormatter = UsersFormatter.withUserFormatter(userFormatter);
    protected static final Formatter<Direction> directionFormatter = new DirectionFormatter();
    protected static final Formatter<Line> lineFormatter = LineFormatter.withDirectionFormatter(directionFormatter);
    protected static final Formatter<LadderReword> ladderRewordFormatter = new LadderRewordFormatter();
}
