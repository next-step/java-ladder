package com.jaeyeonling.ladder;

import com.jaeyeonling.ladder.domain.ladder.HeightOfLadder;
import com.jaeyeonling.ladder.domain.ladder.LadderGame;
import com.jaeyeonling.ladder.domain.ladder.LadderGameGenerator;
import com.jaeyeonling.ladder.domain.line.*;
import com.jaeyeonling.ladder.domain.user.User;
import com.jaeyeonling.ladder.domain.user.Username;
import com.jaeyeonling.ladder.domain.user.Users;
import com.jaeyeonling.ladder.view.console.ConsoleInputView;
import com.jaeyeonling.ladder.view.console.ConsoleOutputView;
import com.jaeyeonling.ladder.view.format.*;

public class Application {

    private final LadderGameGenerator ladderGameGenerator;
    private final Formatter<LadderGame> ladderGameFormatter;

    private Application(final LadderGameGenerator ladderGameGenerator,
                        final Formatter<LadderGame> ladderGameFormatter) {
        this.ladderGameGenerator = ladderGameGenerator;
        this.ladderGameFormatter = ladderGameFormatter;
    }

    public static void main(final String... args) {
        final PointGenerateStrategy pointGenerateStrategy = new RandomPointGenerateStrategy();
        final LineGenerator lineGenerator = StrategyBaseLineGenerator.withStrategy(pointGenerateStrategy);
        final LadderGameGenerator ladderGameGenerator = LadderGameGenerator.withLineGenerator(lineGenerator);

        final Formatter<Username> usernameFormatter = new UsernameFormatter();
        final Formatter<User> userFormatter = UserFormatter.withUsernameFormatter(usernameFormatter);
        final Formatter<Users> usersFormatter = UsersFormatter.withUserFormatter(userFormatter);

        final Formatter<Boolean> pointFormatter = new PointFormatter();
        final Formatter<Line> lineFormatter = LineFormatter.withPointFormatter(pointFormatter);
        final Formatter<Lines> linesFormatter = LinesFormatter.withLineFormatter(lineFormatter);

        final Formatter<LadderGame> ladderGameFormatter = LadderGameFormatter.withUsersFormatterAndLinesFormatter(
                usersFormatter, linesFormatter);

        final Application application = new Application(ladderGameGenerator, ladderGameFormatter);

        application.start();
    }

    private void start() {
        final Users users = Users.ofSeparator(ConsoleInputView.readUsers());
        final HeightOfLadder ladderHeight = HeightOfLadder.valueOf(ConsoleInputView.readLadderHeight());

        final LadderGame ladderGame = ladderGameGenerator.generate(users, ladderHeight);

        ConsoleOutputView.printResult(ladderGameFormatter.format(ladderGame));
    }
}
