package nextstep.laddar.view;

import java.util.List;
import nextstep.laddar.Laddar;
import nextstep.laddar.Line;
import nextstep.laddar.User;

public class ResultView {

    private static final String BLANK = " ";
    private static final String HORIZONTAL_LINE = "-";
    private static final String VERTICAL_LINE = "|";

    private static final String NAME_FORMAT = "%" + User.getMaxNameLength() + "s";


    public static void printLaddar(Laddar laddar) {
        StringBuilder sb = new StringBuilder();
        List<Line> lines = laddar.getLines();
        int height = lines.size();
        for (Line line : lines) {
            List<Boolean> positions = line.getPositions();
            sb.append(BLANK.repeat(User.getMaxNameLength()));
            addOneLine(sb, positions);
            sb.append(VERTICAL_LINE);
            sb.append("\n");

        }
        System.out.println(sb);
    }

    private static void addOneLine(StringBuilder sb, List<Boolean> positions) {
        for (int i = 0; i < positions.size() - 1; i++) {
            boolean hasLine = positions.get(i);
            sb.append(VERTICAL_LINE);
            addHorizontalLine(sb, hasLine);
            addBlankLine(sb, hasLine);
        }
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
            sb.append(BLANK.repeat(User.getMaxNameLength()));
        }
    }

    private static void addHorizontalLine(StringBuilder sb, boolean hasLine) {
        if (hasLine) {
            sb.append(HORIZONTAL_LINE.repeat(User.getMaxNameLength()));
        }
    }
}
