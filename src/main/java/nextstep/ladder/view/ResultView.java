package nextstep.ladder.view;

import static nextstep.ladder.view.Shape.*;

import java.util.List;
import nextstep.ladder.Ladder;
import nextstep.ladder.Line;
import nextstep.ladder.User;

public class ResultView {
    private static final String NAME_FORMAT = "%" + User.NAME_MAX_LENGTH + "s";

    private ResultView() {
    }


    public static void printLaddar(Ladder laddar) {
        StringBuilder sb = new StringBuilder();
        List<Line> lines = laddar.getLines();
        for (Line line : lines) {
            List<Boolean> positions = line.getPositions();
            sb.append(BLANK.makePrintShape(User.NAME_MAX_LENGTH));
            addOneLine(sb, positions);
        }
        System.out.println(sb);
    }

    private static void addOneLine(StringBuilder sb, List<Boolean> positions) {
        for (int i = 0; i < positions.size() - 1; i++) {
            boolean hasLine = positions.get(i);
            sb.append(VERTICAL_LINE.makePrintShape(1));
            addHorizontalLine(sb, hasLine);
            addBlankLine(sb, hasLine);
        }
        sb.append(VERTICAL_LINE.makePrintShape(1)).append("\n");
    }

    public static void printNames(List<User> userNames) {
        System.out.println("실행결과");
        StringBuilder sb = new StringBuilder();
        userNames.forEach((username) ->
                sb.append(String.format(NAME_FORMAT, username.getName()))
        );
        System.out.println(sb);
    }

    private static void addBlankLine(StringBuilder sb, boolean hasLine) {
        if (!hasLine) {
            sb.append(BLANK.makePrintShape(User.NAME_MAX_LENGTH));
        }
    }

    private static void addHorizontalLine(StringBuilder sb, boolean hasLine) {
        if (hasLine) {
            sb.append(HORIZONTAL_LINE.makePrintShape(User.NAME_MAX_LENGTH));
        }
    }
}
