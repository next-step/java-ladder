package nextstep.ladder.view;

public class ResultView {
    public static final String RESULT = "실행결과";

    public void printResult(String names, String lines) {
        printResultPhrase();
        System.out.println(names);
        System.out.println(lines);

    }

    private void printResultPhrase() {
        System.out.println();
        System.out.println(RESULT);
        System.out.println();
    }
}
