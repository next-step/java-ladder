package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Row> rows;

    public Ladder() {
        this.rows = new ArrayList<>();
    }

    public List<Row> make(int wallCount, int Height){
        for(int i = 0; i < Height; i++){
            this.rows.add(new Row(wallCount));
        }
        return this.rows;
    }


}
