package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LadderTest {

    @Test
    @DisplayName("사다리 생성 테스트")
    void createLadder(){
        List<Row> rows = new Ladder().make(4, 5);

        for(Row row: rows){

            for(Column column: row.getColumns()){
                System.out.print(column.isMarked() + " ");
            }
            System.out.println();
        }
    }
}
