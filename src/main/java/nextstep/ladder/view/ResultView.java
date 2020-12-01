package nextstep.ladder.view;

public class ResultView {
    private static final String VERTICAL = "|";

    public void printUsers(String name) {
        System.out.print(String.format("%5s", name));
    }

    public void printVertical() {
        System.out.print(String.format("%5s", VERTICAL));
    }
}