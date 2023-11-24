package ladder.factory;

import ladder.domain.Row;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomRowStrategy implements RowStrategy {

    private static final Random RANDOM = new Random();

    private final int row;
    private final int col;
    private Boolean before = false;

    public RandomRowStrategy(int row, int col) {
        this.row = row;
        this.col = col - 1;
    }

    public List<Row> rows() {
        List<Row> result = new ArrayList<>();
        for (int i = 0; i < this.row; i++) {
            result.add(row(this.col));
        }

        return result;
    }

    private Row row(int col) {
        List<Boolean> cols = new ArrayList<>();
        for (int i = 0; i < col; i++) {
            cols.add(col());
        }

        return new Row(cols);
    }

    private Boolean col() {
        Boolean col = RANDOM.nextBoolean();
        while (!creatable(col)) {
            col = RANDOM.nextBoolean();
        }
        before = col;
        return col;
    }

    private boolean creatable(Boolean current) {
        return !(before && current);
    }

}
