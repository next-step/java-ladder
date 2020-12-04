package nextstep.ladder.view;

public class ResultView {
    private static final String RESULT_MENTION = "실행결과";
    private static final String VERTICAL = "|";
    private static final String BAR = "-----";

    public void printResultMention() {
        System.out.println();
        System.out.println(RESULT_MENTION);
    }

    public void printUsers(String name) {
        System.out.print(String.format("%5s ", name));
    }

    public void drawRight() {
        System.out.print(String.format("%5s", VERTICAL));
        System.out.print(String.format("%5s", BAR));
    }

    public void drawLeft() {
        System.out.print(String.format("%s ", VERTICAL));
    }

    public void drawForward() {
        System.out.print(String.format("%5s ", VERTICAL));
    }
}