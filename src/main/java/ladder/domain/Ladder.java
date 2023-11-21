package ladder.domain;

import ladder.domain.util.BooleanGenerator;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    public static List<Row> makeLadder(int intervalCount,int height, BooleanGenerator booleanGenerator){
        List<Row> rows = new ArrayList<>();;
        for(int i = 0; i < height; i++){
            rows.add(new Row(intervalCount, booleanGenerator));
        }
        return rows;
    }

}
