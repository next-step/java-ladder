package ladder.view;

import ladder.domain.Column;
import ladder.domain.Name;
import ladder.domain.Names;
import ladder.domain.Row;

import java.util.List;

public class ResultView {

    public static void printResult(Names names, List<Row> Rows) {
        names.names().forEach(ResultView::printName);
        Rows.forEach(ResultView::printRow);
    }

    private static void printName(Name name) {
        System.out.printf("%6s", name);
    }

    private static void printRow(Row row) {
        printNewLine();
        row.getColumns().forEach((col)->{
            System.out.print(col.isMarked() ? "-----" : "     ");
            System.out.print("|");
        });
    }

    private static void printNewLine() {
        System.out.println();
        System.out.printf("%6s","|");
    }
}
