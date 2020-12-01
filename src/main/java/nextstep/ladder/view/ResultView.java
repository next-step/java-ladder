package nextstep.ladder.view;

public class ResultView {
    private static final String VERTICAL = "|";
    private static final String RESULT_MENTION = "실행결과";

    public void printResultMention() {
        System.out.println();
        System.out.println(RESULT_MENTION);
    }

    public void printUsers(String name) {
        System.out.print(String.format("%5s ", name));
    }

    public void printVertical() {
        System.out.print(String.format("%5s ", VERTICAL));
    }
}