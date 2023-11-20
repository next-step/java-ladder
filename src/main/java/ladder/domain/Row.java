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
        this.make(0);
    }

    public List<Column> getColumns() {
        return columns;
    }

    private void inputValidation(int wallCount) {
        if(wallCount < 1){
            throw new IllegalArgumentException("벽의 개수는 0보다 작을 수 없습니다.");
        }
    }

    public Row(List<Name> names){
        this(names.size()-1);
    }

    private void make(int count){
        if(count == this.wallCount){
            return;
        }
        boolean marked = new Random().nextBoolean();

        if(marked && count>0 && this.columns.get(count-1).isMarked()){
            columns.add(new Column(false));
        }else{
            columns.add(new Column(marked));
        }

        make(count+1);
    }
}
