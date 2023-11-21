package ladder.view;

import ladder.domain.*;

import java.util.List;
import java.util.Map;

public class ResultView {

    public static void printResult(Names names, Ladder ladder, List<String> prizes) {
        names.names().forEach(ResultView::printName);
        ladder.rows().forEach(ResultView::printRow);
        System.out.println();
        prizes.forEach(ResultView::printPrize);
    }

    private static void printName(Name name) {
        System.out.printf("%6s", name);
    }

    private static void printRow(Row row) {
        printNewLine();
        row.getColumns().forEach((col)->{
            System.out.print(col);
            System.out.print("|");
        });
    }

    private static void printPrize(String prize) {
        System.out.printf("%6s", prize);
    }

    private static void printNewLine() {
        System.out.println();
        System.out.printf("%6s","|");
    }

    public static void printPersonPrize(String personName, Map<Name, String> result) {
        System.out.println();
        System.out.println("실행 결과");
        if(personName.equals("all")){
            result.forEach((key, value) -> System.out.println(key + " : " + value));
            return;
        }
        System.out.println(result.get(new Name(personName)));
    }
}
