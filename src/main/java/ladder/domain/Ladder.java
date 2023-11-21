package ladder.domain;

import ladder.domain.util.BooleanGenerator;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Row> rows = new ArrayList<>();
    private final int intervalCount;
    private final int height;
    private final BooleanGenerator booleanGenerator;

    public Ladder(int intervalCount, int height, BooleanGenerator booleanGenerator) {
        this.intervalCount = intervalCount;
        this.height = height;
        this.booleanGenerator = booleanGenerator;
    }

    public int size(){
        return this.rows.size();
    }

    public List<Row> rows(){
        return this.rows;
    }

    public Ladder makeLadder(){
        for(int i = 0; i < this.height; i++){
            this.rows.add(new Row(this.intervalCount, this.booleanGenerator));
        }
        return this;
    }

    public boolean isMarked(int rowCount, int index){
        return this.rows.get(rowCount).isMarked(index);
    }

}
