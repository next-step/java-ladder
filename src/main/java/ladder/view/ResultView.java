package ladder.view;

import ladder.domain.Column;
import ladder.domain.Name;
import ladder.domain.Row;

import java.util.List;

public class ResultView {

    public static void printResult(List<Name> names, List<Row> Rows) {
        names.forEach((name)->{
            System.out.printf("%6s", name);
        });
        for(Row row: Rows){
            System.out.println();
            System.out.printf("%5s","|");
            for(Column col: row.getColumns()){
                if(col.isMarked()){
                    System.out.print("-----");
                }else{
                    System.out.print("     ");
                }
                System.out.print("|");
            }
        }
    }
}
