package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private int height;

    private List<Boolean> line;

    public Line(int height) {
        this.height = height;
        line = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < height; i++) {
            line.add(random.nextBoolean());
        }
    }

    public void checkLine(Line nextLine) {
        for (int i = 0; i < height; i++) {
            changeLine(nextLine, i);
        }
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
