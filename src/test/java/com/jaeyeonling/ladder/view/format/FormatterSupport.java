package com.jaeyeonling.ladder.view.format;

import com.jaeyeonling.ladder.domain.line.Line;
import com.jaeyeonling.ladder.domain.user.User;
import com.jaeyeonling.ladder.domain.user.Username;
import com.jaeyeonling.ladder.domain.user.Users;

public class FormatterSupport {

    protected static final Formatter<Username> usernameFormatter = new UsernameFormatter();
    protected static final Formatter<User> userFormatter = UserFormatter.withUsernameFormatter(usernameFormatter);
    protected static final Formatter<Users> usersFormatter = UsersFormatter.withUserFormatter(userFormatter);
    protected static final Formatter<Boolean> pointFormatter = new PointFormatter();
    protected static final Formatter<Line> lineFormatter = LineFormatter.withPointFormatter(pointFormatter);
}
