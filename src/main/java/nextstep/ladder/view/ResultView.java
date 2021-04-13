package nextstep.ladder.view;

import java.util.List;

public class ResultView {
    public static final String RESULT = "실행결과";

    public void printResult(List<String> names, String lines) {
        printResultPhrase();
        printPlayerNames(names);
        System.out.println(lines);
    }

    private void printPlayerNames(List<String> names) {
        names.forEach(name -> System.out.print(name + " "));
        System.out.println();
    }

    private void printResultPhrase() {
        System.out.println();
        System.out.println(RESULT);
        System.out.println();
    }
}
