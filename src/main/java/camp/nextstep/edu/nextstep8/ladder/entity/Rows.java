package camp.nextstep.edu.nextstep8.ladder.entity;

import java.util.ArrayList;
import java.util.List;

public class Rows {
    private final List<Row> rows;

    public Rows(int cols, int height) {
        this.rows = generateRows(cols, height);
    }

    public Row get(int rowNumber) {
        return rows.get(rowNumber);
    }

    public int count() {
        return rows.size();
    }

    private List<Row> generateRows(int cols, int height){
        List<Row> rows = new ArrayList<>();
        for(int rowNumber = 0; rowNumber < height; rowNumber++) {
            rows.add(new Row(rowNumber, cols));
        }
        return rows;
    }
}
