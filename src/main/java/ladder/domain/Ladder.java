package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Row> rows = new ArrayList<>();;

    public List<Row> make(int wallCount, int height){
        for(int i = 0; i < height; i++){
            this.rows.add(new Row(wallCount));
        }
        return this.rows;
    }


}
