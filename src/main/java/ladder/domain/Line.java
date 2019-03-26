package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Line {

    private int height;
    private List<Boolean> rows;

    public Line(int height) {
        this.height = height;
        rows = new ArrayList<>();
    }

    public List<Boolean> createRow() {
        Random random = new Random();
        IntStream.range(0, height)
                .forEach(count -> rows.add(random.nextBoolean()));

        return rows;
    }

    public void checkLine(Line nextLine) {
        IntStream.range(0, height)
                .forEach(count -> changeLine(nextLine, count));
    }

    private boolean changeLine(Line nextLine, int row) {
        boolean isChange = false;

        if (this.rows.get(row) && nextLine.rows.get(row)) {
            nextLine.rows.set(row, false);
            isChange = true;
        }

        return isChange;
    }

    /**
     * 테스트용 메서드
     */
    public boolean checkLineDuplicate(Line nextLine) {
        for (int i = 0; i < rows.size(); i++) {
            if (changeLine(nextLine, i)) {
                return true;
            }
        }

        return false;
    }

    public List<Boolean> getRows() {
        return rows;
    }
}
