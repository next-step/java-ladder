package ladder.view;

public class ResultConsoleView {
    private final Displayer resultDisplayer;

    public ResultConsoleView(final Displayer resultDisplayer) {
        this.resultDisplayer = resultDisplayer;
    }

    public void show() {
        resultDisplayer.show((String result) -> System.out.println(result));
        System.out.println();
    }
}
