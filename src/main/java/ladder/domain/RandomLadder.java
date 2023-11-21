package ladder.domain;

import ladder.domain.util.BooleanGenerator;
import ladder.domain.util.RandomBooleanGenerator;

import java.util.ArrayList;
import java.util.List;

public class RandomLadder {

    private final List<Row> rows = new ArrayList<>();
    private final int intervalCount;
    private final int height;

    public RandomLadder(int intervalCount, int height, BooleanGenerator booleanGenerator) {
        this.intervalCount = intervalCount;
        this.height = height;
    }

    public int size(){
        return this.rows.size();
    }

    public List<Row> rows(){
        return this.rows;
    }

    public RandomLadder makeLadder(){
        for(int i = 0; i < this.height; i++){
            this.rows.add(new Row(this.intervalCount, new RandomBooleanGenerator()));
        }
        return this;
    }

    public boolean isMarked(int rowCount, int index){
        return this.rows.get(rowCount).isMarked(index);
    }

}
