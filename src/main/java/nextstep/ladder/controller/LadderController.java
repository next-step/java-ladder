package nextstep.ladder.controller;

import nextstep.ladder.domain.*;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderController {

    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int DIRECTION_BOUND = 2;
    private Random random = new Random();

    public void start() {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        InputUsers inputUsers = new InputUsers(inputView.inputParticipants());
        Users users = initUsers(inputUsers);

        Height height = new Height(Integer.parseInt(inputView.inputHeight()));

        resultView.printResultMention();
        printUsers(resultView, users);
        Ladder ladder = initLadder(users, height);
        drawLadders(resultView, ladder);
    }

    public Users initUsers(InputUsers inputUsers) {
        List<User> userList = Arrays.stream(inputUsers.splitUsers())
                .map(User::new)
                .collect(Collectors.toList());

        return new Users(userList);
    }

    private void printUsers(ResultView resultView, Users users) {
        users.getUsers()
                .forEach(user -> resultView.printUsers(user.getName()));
    }

    public Ladder initLadder(Users users, Height height) {
        List<Line> lines = new ArrayList<>();

        IntStream.range(ZERO, height.getHeight())
                .forEach(number -> lines.add(initLine(users)));
        return new Ladder(lines);
    }

    public Line initLine(Users users) {
        List<Point> points = new ArrayList<>();
        Direction direction = null;

        int bound = users.getUsers().size();
        for (int number = ZERO; number < bound; number++) {
            int condition = minusIndex(number, bound);
            direction = decideDirection(direction, condition, () -> random.nextInt(DIRECTION_BOUND));
            points.add(new Point(number, direction));
        }

        return new Line(points);
    }

    private int minusIndex(int number, int bound) {
        if(bound - ONE - number == ZERO) {
            return -ONE;
        }
        return number;
    }

    public Direction decideDirection(Direction direction, int condition, RandomStrategy randomStrategy) {
        if(condition == ZERO) {
            return Direction.from(randomStrategy.randomDirection());
        }

        if(direction == Direction.RIGHT) {
            return Direction.LEFT;
        }

        if(direction == Direction.LEFT || direction == Direction.FORWARD) {
            return checkLastIndex(condition, randomStrategy);
        }

        return direction;
    }

    private Direction checkLastIndex(int condition, RandomStrategy randomStrategy) {
        if(condition == -ONE) {
            return Direction.FORWARD;
        }

        return Direction.from(randomStrategy.randomDirection());
    }

    private void drawLadders(ResultView resultView, Ladder ladder) {
        ladder.getLines()
                .forEach(line -> drawLine(resultView, line.getPoints()));
    }

    private void drawLine(ResultView resultView, List<Point> points) {
        resultView.enterLine();
        points.forEach(point -> checkDirection(resultView, point));
    }

    private void checkDirection(ResultView resultView, Point point) {
        if(point.getDirection() == Direction.RIGHT) {
            resultView.drawRight();
        }

        if(point.getDirection() == Direction.LEFT) {
            resultView.drawLeft();
        }

        if(point.getDirection() == Direction.FORWARD) {
            resultView.drawForward();
        }
    }

}
