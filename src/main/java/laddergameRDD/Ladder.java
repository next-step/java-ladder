package laddergameRDD;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Row> ladder = new ArrayList<>();

    public Ladder(int rowCount, int columnCount, SelectStrategy selectStrategy) {
        for (int i = 0; i < rowCount; ++i) {
            ladder.add(new Row(columnCount, selectStrategy));
        }
    }


}
