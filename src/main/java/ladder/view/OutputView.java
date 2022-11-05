package ladder.view;

import java.util.Map;
import ladder.domain.Ladder;
import ladder.domain.Line;

public class OutputView {

    private final static String POINT = "|";
    private final static String LINK = "-----";

    private OutputView() {
    }

    public static void printResult(final Ladder ladder) {
        System.out.println("실행결과\n");
        System.out.println("-".repeat(10));
        ladder.getLines().forEach(OutputView::printLine);
    }

    // TODO: indent 확인
    private static void printLine(final Line line) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\t\t");
        line.getPoints().forEach(point -> {
            stringBuilder.append(POINT);
            if (point.isLinked()) {
                stringBuilder.append(LINK);
            }
        });
        System.out.println(stringBuilder);
    }
}
