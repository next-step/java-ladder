package ladder.view;

import ladder.model.Ladder;
import ladder.model.Line;
import ladder.model.Users;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String LINE = "-----";
    private static final String HEIGHT = "|";
    private static final String EMPTY_LIME = "     ";
    private static final String BLANK = "\t";

    private ResultView() {
    }

    public static void showResult(Users users, Ladder ladder) {
        System.out.println("실행결과");
        showUsers(users);
        showLadder(ladder);
    }

    private static void showUsers(Users users) {
        List<String> names = getNames(users);
        String printNames = names.stream()
                .map(name -> String.format("%5s", name))
                .collect(Collectors.joining(" "));

        System.out.println(printNames);
    }

    private static void showLadder(Ladder ladder) {
        ladder.getLines().stream()
                .map(Line::getPoints)
                .forEach(ResultView::showLine);
    }

    private static void showLine(List<Boolean> points) {
        String line = points.stream()
                .map(ResultView::convertPoint)
                .collect(Collectors.joining());

        System.out.println(BLANK + line + HEIGHT);
    }

    private static String convertPoint(Boolean point) {
        if (point) {
            return HEIGHT + LINE;
        }
        return HEIGHT + EMPTY_LIME;
    }

    private static List<String> getNames(Users users) {
        return users.getUsers().stream()
                .map(user -> user.getName().getName())
                .collect(Collectors.toList());
    }
}
