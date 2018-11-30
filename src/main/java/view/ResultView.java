package view;

import domain.Ladder;
import domain.Line;

public class ResultView {
    public static void printLadder(Ladder ladder, String[] memberArr) {
        System.out.println();
        System.out.println("실행결과");
        for(String str : memberArr) {
            System.out.print(str + "   ");
        }
        System.out.println();
        System.out.println(ladder.drawOneLine());
    }
}
