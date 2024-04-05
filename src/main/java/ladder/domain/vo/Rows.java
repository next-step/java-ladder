package ladder.domain.vo;

import ladder.util.BooleanGenerator;
import ladder.util.RandomBooleanGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Rows {

    private final List<Row> rows;

    private static BooleanGenerator booleanGenerator = new RandomBooleanGenerator();

    public Rows(Integer size){
        this(create(size));
    }

    public Rows(List<Row> rows) {
        this.rows = rows;
    }

    private static List<Row> create(Integer size) {
        List<Row> rows = new ArrayList<>(size);
        rows.add(new Row(booleanGenerator.generate()));

        for (int index = 0; index < size - 1; index ++){
            int finalIndex = index;
            Row newRow = new Row(() -> rows.get(finalIndex).bridgeExist(), booleanGenerator.generate());
            rows.add(newRow);
        }
        return rows;
    }

    public List<Row> rows(){
        return Collections.unmodifiableList(rows);
    }

    public Integer size(){
        return rows.size();
    }

}
