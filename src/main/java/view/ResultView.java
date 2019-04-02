package view;

import domain.Line;
import util.Console;

public class ResultView {

    public static void printLine(Line line) {
        Console.print(line.printLine());
    }

}
