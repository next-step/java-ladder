package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class WidthGenerator {
    private List<Boolean> widthLines;

    public WidthGenerator(int userCounts) {
        this.widthLines = generate(userCounts);
    }

    public WidthGenerator(List<Boolean> widthLines) {
        this.widthLines = new ArrayList<>(widthLines);
    }

    public List<Boolean> getWidthLines() {
        return widthLines;
    }

    public List<Boolean> generate(int personCount) {
        Stack<Boolean> lines = new Stack<>();
        for (int line = 0, maxLine = personCount - 1; line < maxLine; line++) {
            push(lines);
        }
        return new ArrayList<>(lines);
    }

    private void push(Stack<Boolean> widthLines) {
        if (!widthLines.empty() && widthLines.peek()) {
            widthLines.push(false);
            return;
        }
        widthLines.push(Math.round(Math.random()) < 0.5);
    }

}
