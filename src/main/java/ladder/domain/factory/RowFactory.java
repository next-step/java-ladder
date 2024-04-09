package ladder.domain.factory;

import ladder.domain.vo.Row;
import ladder.domain.vo.Rows;
import ladder.util.BooleanGenerator;

import java.util.ArrayList;
import java.util.List;

public final class RowFactory {

    private final BooleanGenerator booleanGenerator;

    public RowFactory(BooleanGenerator booleanGenerator) {
        this.booleanGenerator = booleanGenerator;
    }

    public Rows createRandom(int size){
        return new Rows(createRows(size));
    }

    private List<Row> createRows(int size) {
        List<Row> rowList = new ArrayList<>(size);

        rowList.add(new Row(booleanGenerator.generate()));

        for (int index = 0; index < size - 1; index++) {
            int finalIndex = index;
            rowList.add(new Row(() -> rowList.get(finalIndex).bridgeExist(), booleanGenerator.generate()));
        }

        return rowList;
    }
}
