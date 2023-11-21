package ladder.domain;


import ladder.domain.util.BooleanGenerator;

import java.util.ArrayList;
import java.util.List;

public class Row{

    private final List<Column> columns;
    private final int intervalCount;
    private BooleanGenerator booleanGenerator;

    public Row(int intervalCount, BooleanGenerator booleanGenerator) {
        inputValidation(intervalCount);
        this.intervalCount = intervalCount;
        this.booleanGenerator = booleanGenerator;
        this.columns = new ArrayList<>();
        this.recursiveMake(0);
    }

    private void inputValidation(int wallCount) {
        if(wallCount < 1){
            throw new IllegalArgumentException("벽의 개수는 0보다 작을 수 없습니다.");
        }
    }

    public boolean isMarked(int index){
        return this.columns.get(index).isMarked();
    }

    public List<Column> getColumns() {
        return columns;
    }

    private void recursiveMake(int count){
        if(count == this.intervalCount){
            return;
        }
        boolean marked = this.booleanGenerator.generate();

        if(beforeIsMarked(count, marked)){
            columns.add(Column.of(false));
            recursiveMake(count+1);
            return;
        }

        columns.add(Column.of(marked));
        recursiveMake(count+1);
    }

    private boolean beforeIsMarked(int count, boolean marked) {
        return marked && count > 0 && this.columns.get(count - 1).isMarked();
    }
}
