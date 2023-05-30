package ladder.ui;

import ladder.Ladder;
import ladder.Line;

import java.util.List;

public class PrintView {
    public static void printResult(List<String> names, Ladder ladder) {
        System.out.println("실행결과");
        printName(names);
        printLadder(ladder);
    }

    private static void printName(List<String> names) {
        names.stream()
                .map(name -> {
                    int padding = 5 - name.length();
                    String paddedName = name + " ".repeat(padding);
                    return paddedName;
                })
                .forEach(System.out::print);
        System.out.println();
    }

    private static void printLadder(Ladder ladder) {
        List<Line> lines = ladder.getLines();
        lines.forEach(line -> {
            printColumn();
            line.getPoints().forEach(point -> {
                printRow(point);
                printColumn();
            });
            System.out.println();
        });
    }

    private static void printColumn(){
        System.out.print("|");
    }

    private static void printRow(boolean point){
        if(point){
            System.out.print("-----");
        } else{
            System.out.print("     ");
        }
    }
}
