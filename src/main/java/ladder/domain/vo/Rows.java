package ladder.domain.vo;

import java.util.Collections;
import java.util.List;

public class Rows {

    private final List<Row> rowList;

    public Rows(List<Row> rowList) {
        this.rowList = rowList;
    }

    public List<Row> rows(){
        return Collections.unmodifiableList(rowList);
    }

    public int size(){
        return rowList.size();
    }

}
