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
//        drawLadders(resultView, ladder);
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

    private Ladder initLadder(Users users, Height height) {
        List<Line> lines = new ArrayList<>();

        IntStream.range(ZERO, height.getHeight())
                .forEach(number -> lines.add(initLine(users)));
        return new Ladder(lines);
    }

    private Line initLine(Users users) {
        List<Point> points = new ArrayList<>();
        Direction direction = null;

        int bound = users.getUsers().size();
        for (int number = ZERO; number < bound; number++) {
            if(number == 0) {
                direction = Direction.from(random.nextInt(1));
            } else if(direction.getMove() == 1) {
                direction = Direction.from(-1);
            } else if(direction.getMove() ==-1) {
                if(number == bound - 1) {
                    direction = Direction.from(0);
                } else {
                    direction = Direction.from(random.nextInt(1));
                }
            }
            points.add(new Point(number, direction));
        }

//        IntStream.range(ZERO, users.getUsers().size())
//                .forEach(number -> {
//                    Direction direction = Direction.from(decideDirection(int number));
//                    points.add(initPoint(number, direction));
//                });

        return new Line(points);
    }

//    private void drawLadders(ResultView resultView, Height height, Users users) {
//        IntStream.range(ZERO, height.getHeight())
//                .forEach(number -> drawLines(resultView, users));
//    }

//    private void drawLadders(ResultView resultView, Height height, Users users) {
//        IntStream.range(ZERO, height.getHeight())
//                .forEach(number -> {
//                    drawLines(resultView, users);
//                });
//    }
//
//    private void drawLines(ResultView resultView, Users users) {
//        System.out.println();
//        IntStream.range(ZERO, users.getUsers().size())
//                .forEach(number -> resultView.printVertical());
//    }


}
