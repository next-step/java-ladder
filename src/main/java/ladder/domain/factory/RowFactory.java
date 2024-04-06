package ladder.domain.factory;

import ladder.domain.vo.Row;
import ladder.domain.vo.RowCreateStrategy;
import ladder.domain.vo.Rows;
import ladder.util.BooleanGenerator;
import ladder.util.RandomBooleanGenerator;

import java.util.ArrayList;
import java.util.List;

public final class RowFactory {

    private RowFactory() {
    }

    public static Rows createRandom(int size){
        return new Rows(createRows(size, new RandomBooleanGenerator()));
    }

    private static List<Row> createRows(int size,
                                        BooleanGenerator booleanGenerator) {
        List<Row> rowList = new ArrayList<>(size);

        rowList.add(new Row(booleanGenerator.generate()));

        for (int index = 0; index < size - 1; index++) {
            int finalIndex = index;
            rowList.add(new Row(() -> rowList.get(finalIndex).bridgeExist(), booleanGenerator.generate()));
        }

        return rowList;
    }
}
