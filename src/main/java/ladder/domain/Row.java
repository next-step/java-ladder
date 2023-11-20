package ladder.domain;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Row{

    private final List<Column> columns = new ArrayList<>();
    private final int wallCount;

    public Row(int wallCount) {
        inputValidation(wallCount);
        this.wallCount = wallCount;
        this.RecursiveMake(0);
    }

    private void inputValidation(int wallCount) {
        if(wallCount < 1){
            throw new IllegalArgumentException("벽의 개수는 0보다 작을 수 없습니다.");
        }
    }

    public List<Column> getColumns() {
        return columns;
    }

    private void RecursiveMake(int count){
        if(count == this.wallCount){
            return;
        }
        boolean marked = new Random().nextBoolean();

        if(beforeIsMarked(count, marked)){
            columns.add(Column.of(false));
        }else{
            columns.add(Column.of(marked));
        }
        RecursiveMake(count+1);
    }

    private boolean beforeIsMarked(int count, boolean marked) {
        return marked && count > 0 && this.columns.get(count - 1).isMarked();
    }
}
