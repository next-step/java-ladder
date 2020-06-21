package nextstep.step3.view;

import nextstep.step3.domain.Ladder;
import nextstep.step3.domain.Line;
import nextstep.step3.domain.User;
import nextstep.step3.resource.LadderStringResource;

import java.util.List;
import java.util.Map;

public class ResultView {

    public void showLadderResult(List<User> users, Ladder ladder) {
        System.out.println();
        System.out.println(LadderStringResource.LADDER_RESULT_TEXT);
        System.out.println();
        printUserName(users);
        System.out.println();
        printLadderLine(ladder.getLines());
    }

    private void printUserName(List<User> users) {
        users.forEach(user -> System.out.printf("%-6s", user.getUserName()));
    }

    private void printLadderLine(List<Line> lines) {
        lines.forEach(line -> {
            System.out.print(LadderStringResource.BAR);
            printLine(line);
            System.out.println();
        });
    }

    private void printLine(Line line) {
        line.getPoints().stream()
                .peek(point -> System.out.print(point ? LadderStringResource.LINE : LadderStringResource.NO_LINE))
                .forEach(point -> System.out.print(LadderStringResource.BAR));
    }

    public void showPlayResult(List<String> playResult) {
        playResult.forEach(result -> System.out.printf("%-6s", result));
        System.out.println();
    }

    public void showUserResult(User user) {
        System.out.println(LadderStringResource.PLAY_RESULT_TEXT);
        System.out.println(user.getResult());
        System.out.println();
    }

    public void showAllResult(Map<String, User> resultMap) {
        System.out.println(LadderStringResource.PLAY_RESULT_TEXT);
        resultMap.forEach((key, value) -> System.out.println(key + " : " + value.getResult()));
        System.out.println();
    }
}
