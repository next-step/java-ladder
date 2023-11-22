package ladder.fixture;

import ladder.domain.Row;
import ladder.factory.RowFactory;

import java.util.ArrayList;
import java.util.List;

public class FixedRowFactory extends RowFactory {

    private List<Row> givenRows;

    public FixedRowFactory(List<List<Boolean>> givenRows) {
        List<Row> result = new ArrayList<>();
        for (List<Boolean> cols : givenRows) {
            result.add(new Row(cols));
        }
        this.givenRows = result;
    }

    public List<Row> rows(int row, int col) {
        return this.givenRows;
    }

}
