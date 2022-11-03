package ladder.view;

public class LineConsoleView {
    private final Displayer lineDisplayer;

    public LineConsoleView(final Displayer lineDisplayer) {
        this.lineDisplayer = lineDisplayer;
    }

    public void show() {
        lineDisplayer.show((String points) -> System.out.println(points));
    }
}
