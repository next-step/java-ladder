package ladder.view;

import java.util.List;

public class ResultView {

    public static void printPlayerName(List<String> names) {
        names.forEach(name -> System.out.printf("%5s ",name));
    }
}
