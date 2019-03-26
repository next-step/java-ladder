package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {

    private int height;
    private List<Boolean> rows;

    public Line(int height) {
        this.height = height;
        rows = new ArrayList<>();
    }

    public List<Boolean> createRow() {
        for (int i = 0; i < height; i++) {
            addRow(getRandomValue());
        }
        return rows;
    }

    public void addRow(boolean randomValue) {
        rows.add(randomValue);
    }

    public boolean getRandomValue() {
        Random random = new Random();
        return random.nextBoolean();
    }

    public void checkLine(Line nextLine) {
        for (int i = 0; i < height; i++) {
            changeLine(nextLine, i);
        }
    }

    public boolean changeLine(Line nextLine, int row) {
        boolean isChange = false;

        if (this.rows.get(row) && nextLine.rows.get(row)) {
            nextLine.rows.set(row, false);
            isChange = true;
        }

        return isChange;
    }

    public List<Boolean> getRows() {
        return rows;
    }
}
