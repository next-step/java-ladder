package ladder.view;

import ladder.domain.Name;
import ladder.domain.Names;

public class ResultView {
    public static String getDefaultResultText() {
        return "실행결과";
    }

    public static String getNamesView(Names names) {
        return names.getNames().stream()
                .map(Name::getViewName)
                .reduce("", (name1, name2) -> name1 + name2);
    }
}
