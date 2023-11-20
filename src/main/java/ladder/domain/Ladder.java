package ladder.domain;

import ladder.domain.util.BooleanGenerator;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Row> rows = new ArrayList<>();;
    private final BooleanGenerator booleanGenerator;
    private final int intervalCount;
    private final int height;

    public Ladder(int intervalCount,int height, BooleanGenerator booleanGenerator) {
        this.booleanGenerator = booleanGenerator;
        this.intervalCount = intervalCount;
        this.height = height;

    }

    public List<Row> makeLadder(){
        for(int i = 0; i < this.height; i++){
            this.rows.add(new Row(this.intervalCount, this.booleanGenerator));
        }
        return this.rows;
    }

}
