package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Line {
    private int height;

    private List<Boolean> line;

    public Line(int height) {
        this.height = height;
        line = new ArrayList<>();
        Random random = new Random();
        IntStream.range(0, height)
                .forEach(count -> line.add(random.nextBoolean()));
    }

    public void checkLine(Line nextLine) {
        IntStream.range(0, height)
                .forEach(count -> changeLine(nextLine, count));
    }

    public boolean changeLine(Line nextLine, int row) {
        boolean isChange = false;

        if (this.line.get(row) && nextLine.line.get(row)) {
            nextLine.line.set(row, false);
            isChange = true;
        }

        return isChange;
    }

    public boolean checkLineDuplicate(Line nextLine) {
        for (int i = 0; i < line.size(); i++) {
            if (changeLine(nextLine, i)) {
                return true;
            }
        }

        return false;
    }

    public List<Boolean> getLine() {
        return line;
    }
}
