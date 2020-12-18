package nextstep.step2.view;

import nextstep.step2.VO.Ladder;
import nextstep.step2.VO.Point;
import nextstep.step2.VO.User;
import nextstep.step2.VO.Users;

import java.util.stream.Collectors;

public class OutputView {
    private static final String START_RESULT_PRINT = "실행 결과";

    public static void printUsers(Users users) {
        String participantsNames = users.getUserList()
                .stream()
                .map(User::getName)
                .map(OutputView::convertUserNamePrint)
                .collect(Collectors.joining(" "));
        System.out.println(participantsNames);
    }

    public static void printLadder(Ladder ladder) {
        String ladderString = ladder.getLadder().stream()
                .map(line -> line.getLine().stream()
                        .map(OutputView::pointToStringPrint).collect(Collectors.joining())
                ).collect(Collectors.joining(System.lineSeparator()));
        System.out.println(ladderString);
    }

    private static String pointToStringPrint(Point point) {
        if (point.checkRightDirection()) {
            return "|-----";
        }
        return "|     ";
    }

    private static String convertUserNamePrint(String name) {
        StringBuilder stringBuilder = new StringBuilder("     ");
        stringBuilder.replace(0, name.length(), name);
        return stringBuilder.toString();
    }
}
