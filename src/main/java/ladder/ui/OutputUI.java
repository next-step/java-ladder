package ladder.ui;

import ladder.Line;
import ladder.Lines;
import ladder.Point;

import java.util.List;

public class OutputUI {

    public static final String LADDER_LINE = "|-----";
    public static final String LADDER_NO_LINE = "|     ";
    public static final String LADDER_BEGIN_SPACE = "     ";
    public static final String LADDER_END_LINE = "|";
    public static final String NAME_SPACE = " ";
    public static final int MAX_NAME_LENGTH = 5;

    public static void printLadder(String nameOfPersons, Lines lines) {
        printBeginMessage();

        String[] names = nameOfPersons.split(",");
        int lineHeight = lines.getLineHeight();
        List<Line> lineList = lines.getLineList();

        printPersons(names);
        printLadder(lineHeight, lineList);
    }

    // stream으로 바꾸자.
    private static void printLadder(int lineHeight, List<Line> lineList) {
        for (int i = 0; i < lineHeight; i++) {
            Line line = lineList.get(i);
            List<Point> points = line.getPoints();

            System.out.print(LADDER_BEGIN_SPACE);
            for (int j = 0; j < points.size() -1 ; j++) {
                Point point = points.get(j);
                if (point.isValue()) {
                    System.out.print(LADDER_LINE);
                } else {
                    System.out.print(LADDER_NO_LINE);
                }
            }

            System.out.print(LADDER_END_LINE);

            System.out.println();
        }
    }

    private static void printBeginMessage() {
        System.out.println();
        System.out.println("실행 결과");
        System.out.println();
    }

    // stream으로 바꾸자.
    private static void printPersons(String[] names) {
        for (String name : names) {
            StringBuilder builder = new StringBuilder();
            int nameLength = MAX_NAME_LENGTH - name.length();

            if (nameLength > 0) {
                for (int i = 0; i <= nameLength; i++) {
                    builder.append(NAME_SPACE);
                }
            } else {
                builder.append(NAME_SPACE);
            }

            System.out.print(builder.append(name));
        }

        System.out.println();
    }
}
