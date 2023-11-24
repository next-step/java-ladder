package ladder.fixture;

import ladder.domain.Row;
import ladder.factory.RowStrategy;

import java.util.ArrayList;
import java.util.List;

public class FixedRowStrategy implements RowStrategy {

    private List<Row> givenRows;

    public FixedRowStrategy(List<List<Boolean>> givenRows) {
        List<Row> result = new ArrayList<>();
        for (List<Boolean> cols : givenRows) {
            result.add(new Row(cols));
        }
        this.givenRows = result;
    }

    public List<Row> rows() {
        return this.givenRows;
    }

}
