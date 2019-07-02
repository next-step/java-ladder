package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Name;
import ladder.domain.Names;

import java.util.stream.Collectors;

public class ResultView {
    public static final String HORIZONTAL_LINE_EXIST_TEXT;
    public static final String HORIZONTAL_LINE_NOT_EXIST_TEXT;

    static {
        String existText = "";
        String notExistText = "";
        for (int i = 0; i < Name.MAX_NAME_LENGTH; i++) {
            existText += "-";
            notExistText += " ";
        }
        HORIZONTAL_LINE_EXIST_TEXT = existText;
        HORIZONTAL_LINE_NOT_EXIST_TEXT = notExistText;
    }

    public static String getDefaultResultText() {
        return "\n실행결과\n";
    }

    public static String getNamesView(Names names) {
        return names.getNames().stream()
                .map(Name::getViewName).collect(Collectors.joining(" "));
    }

    public static String getLadderView(Ladder ladder) {

        String result = "";
        for (int i = 0; i < ladder.height(); i++) {
            result += ladder.horizontalLinesByLevel(i).getHorizontalLines()
                    .stream()
                    .map(horizontalLine -> horizontalLine.hasLine() ? HORIZONTAL_LINE_EXIST_TEXT : HORIZONTAL_LINE_NOT_EXIST_TEXT)
                    .collect(Collectors.joining("|"));
            result += "|\n";
        }
        return result;
    }
}
