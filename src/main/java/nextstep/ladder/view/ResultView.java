package nextstep.ladder.view;

import nextstep.ladder.domain.*;

import java.util.List;
import java.util.Map;

public class ResultView {
    private static final String LADDER_MENTION = "사다리 결과";
    private static final String RESULT_MENTION = "실행 결과";
    private static final String VERTICAL = "|";
    private static final String BAR = "-----";

    public void printResultMention() {
        System.out.println();
        System.out.println(LADDER_MENTION);
    }

    public void printUsers(Users users) {
        users.getUsers()
                .forEach(user -> System.out.print(String.format("%5s ", user.getName())));
    }

    public void drawLadders(Ladder ladder) {
        ladder.getLines()
                .forEach(line -> drawLine(line.getPoints()));
        System.out.println();
    }

    private void drawLine(List<Point> points) {
        enterLine();
        points.forEach(this::checkDirection);
    }

    private void enterLine() {
        System.out.println();
    }

    private void checkDirection(Point point) {
        if(point.getDirection() == Direction.RIGHT) {
            drawRight();
        }

        if(point.getDirection() == Direction.LEFT) {
            drawLeft();
        }

        if(point.getDirection() == Direction.FORWARD) {
            drawForward();
        }
    }

    private void drawRight() {
        System.out.print(String.format("%5s", VERTICAL));
        System.out.print(String.format("%5s", BAR));
    }

    private void drawLeft() {
        System.out.print(String.format("%s ", VERTICAL));
    }

    private void drawForward() {
        System.out.print(String.format("%5s ", VERTICAL));
    }

    public void printResult(Map<String, Result> userResultMap, String inputResultUser) {
        System.out.println();
        System.out.println(RESULT_MENTION);
        if(inputResultUser.equals("all")) {
            printAllResult(userResultMap);
            return;
        }
        printUserResult(userResultMap, inputResultUser);
    }

    private void printAllResult(Map<String, Result> userResultMap) {
        userResultMap.keySet()
                .forEach(key -> printMapResult(userResultMap, key));
    }

    private void printMapResult(Map<String, Result> userResultMap, String key) {
        System.out.println(key + " : " + userResultMap.get(key));
    }

    private void printUserResult(Map<String, Result> userResultMap, String inputResultUser) {
        String user = userResultMap.keySet().stream()
                .filter(key -> key.equals(inputResultUser))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("참가자가 아닙니다."));
        printMapResult(userResultMap, user);
    }
}
