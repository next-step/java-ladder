package ladder.view;

import java.util.List;

import ladder.domain.Line;

public class ConsoleView {
    private final NamesDisplay nameDisplay;
    private final List<Line> ladder;
    private final LineDisplay lineDisplay;

    public ConsoleView(final List<String> names, final List<Line> ladder, final int maxNameSize) {
        this(ladder, new NamesDisplay(names, displaySize(names, maxNameSize)), new LineDisplay(displaySize(names, maxNameSize)));
    }

    public ConsoleView(final List<Line> ladder, final NamesDisplay nameDisplay, final LineDisplay lineDisplay) {
        this.ladder = ladder;
        this.nameDisplay = nameDisplay;
        this.lineDisplay = lineDisplay;
    }
    
    public void show() {
        showNames();
        showLadder();
    }

    private static int displaySize(List<String> names, int maxNameSize) {
        return maxNameSize + names.size() - maxNameSize;
    }
    
    private void showLadder() {
        for (Line line : ladder) {
            System.out.println(lineDisplay.show(line.points()));
        }
    }
    
    private void showNames() {
        System.out.println(nameDisplay.get());
    }
}
