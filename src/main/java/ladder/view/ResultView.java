package ladder.view;

import ladder.domain.Name;
import ladder.domain.Names;

import java.util.stream.Collectors;

public class ResultView {
    public static String getDefaultResultText() {
        return "\n실행결과\n";
    }

    public static String getNamesView(Names names) {
        return names.getNames().stream()
                .map(Name::getViewName).collect(Collectors.joining(" "));
    }
}
