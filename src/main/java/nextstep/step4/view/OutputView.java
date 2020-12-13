package nextstep.step4.view;

import nextstep.step4.domain.*;

import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String RESULT_MENTION = "사다리 결과";
    private static final String VERTICAL = "|";
    private static final String BAR = "-----";
    private static final String COMMA_DELIMITER = " : ";

    public void mentionResult() {
        System.out.println();
        System.out.println(RESULT_MENTION);
    }

    public void printLadder(GameCriteria gameCriteria, Ladder ladder) {
        System.out.println();
        printUsers(gameCriteria.getUserList());
        drawLadder(ladder);
        printResult(gameCriteria.getResultList());

    }

    private void printUsers(List<User> userList) {
        userList.forEach(user -> System.out.print(String.format("%5s ", user)));
    }

    private void drawLadder(Ladder ladder) {
        ladder.getLines()
                .forEach(line -> drawLine(line.getIndexList()));
        System.out.println();
    }

    private void drawLine(List<Index> indexList) {
        System.out.println();
        indexList.forEach(this::checkDirection);
    }

    private void checkDirection(Index index) {
        if(index.getDirection() == Direction.RIGHT) {
            drawRight();
        }

        if(index.getDirection() == Direction.LEFT) {
            drawLeft();
        }

        if(index.getDirection() == Direction.FORWARD) {
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

    private void printResult(List<Result> resultList) {
        resultList.forEach(result -> System.out.print(String.format("%5s ", result)));
    }

    public void printResultUser(Map<String, Result> userResultMap, String resultUser) {
        if(resultUser.equals("all")) {
            printAllUser(userResultMap);
        }
        printUser(userResultMap, resultUser);
    }

    private void printAllUser(Map<String, Result> userResultMap) {
        userResultMap.forEach((key, value) -> {
            System.out.println(key + COMMA_DELIMITER + value);
        });
    }

    private void printUser(Map<String, Result> userResultMap, String resultUser) {
        System.out.println(userResultMap.get(resultUser));
    }
}
