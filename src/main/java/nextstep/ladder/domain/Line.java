package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {

    private List<Boolean> cols;

    public Line(int totalUser) {
        int totalColumn = getTotalColumn(totalUser);
        this.cols = generateCols(totalColumn);
    }

    private List<Boolean> generateCols(int totalColumn) {
        List<Boolean> cols = new ArrayList<>();
        for (int i = 0; i < totalColumn; i++) {
            cols.add(generateCol(cols, i));
        }
        return cols;
    }

    private Boolean generateCol(List<Boolean> cols, int colNo) {
        if (isFirstCol(colNo)) {
            return generateRandomBoolean();
        }
        if (isPrevColTrue(cols, colNo)) {
            return false;
        }
        return generateRandomBoolean();
    }

    private Boolean generateRandomBoolean() {
        return new Random().nextInt(2) == 0;
    }

    private boolean isPrevColTrue(List<Boolean> cols, int colNo) {
        return cols.get(colNo - 1);
    }

    private boolean isFirstCol(int colNo) {
        return colNo == 0;
    }

    private int getTotalColumn(int totalUser) {
        return totalUser - 1;
    }

    @Override
    public String toString() {
        String result = "|";
        for (int i = 0; i < cols.size(); i++) {

            result = result + (cols.get(i)? "----|":"    |");
        }
        return result;
    }
}
