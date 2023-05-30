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
        for (String name : names) {
            int padding = 5 - name.length();
            System.out.print(name);
            for (int i = 0; i < padding; i++) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }


    private static void printLadder(Ladder ladder) {
        List<Line> lines = ladder.getLines();
        for (Line line : lines) {
            printColumn();
            for (Boolean point : line.getPoints()) {
                printRow(point);
                printColumn();
            }
            System.out.println();
        }
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
