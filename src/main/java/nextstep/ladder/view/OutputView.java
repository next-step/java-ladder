package nextstep.ladder.view;

import nextstep.ladder.domain.ladder.Direction;
import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.LadderLine;
import nextstep.ladder.domain.ladder.Point;
import nextstep.ladder.domain.user.Name;
import nextstep.ladder.domain.user.User;
import nextstep.ladder.domain.user.UserCollection;

import java.util.stream.Collectors;

public class OutputView {

    private static final String HORIZON = "─";
    private static final String BLANK = " ";
    private static final int TEXT_WIDTH = 5;

    private OutputView() {
    }

    public static void drawUserName(UserCollection users) {
        String userNameFormat = users.getUsers()
                .stream()
                .map(User::getName)
                .map(Name::getValue)
                .map(name -> String.format("%5s", name))
                .collect(Collectors.joining());
        System.out.println(userNameFormat);
    }

    public static void drawLadderGame(UserCollection users, Ladder ladder) {
        drawUserName(users);
        drawLadder(ladder);
    }

    private static void drawLadder(Ladder ladder) {
        ladder.getLadderLines()
                .stream()
                .map(OutputView::ladderLineFormat)
                .forEach(System.out::println);
    }

    private static String ladderLineFormat(LadderLine ladderLine) {
        return ladderLine.getPoints()
                .stream()
                .map(Point::getDirection)
                .map(OutputView::pointLineFormat)
                .collect(Collectors.joining());
    }

    private static String pointLineFormat(Direction direction) {
        if (Direction.LEFT == direction) {
            return new String(new char[TEXT_WIDTH]).replace("\0", HORIZON) + direction.getShape();
        }
        return new String(new char[TEXT_WIDTH]).replace("\0", BLANK) + direction.getShape();
    }


}
