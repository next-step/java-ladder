package view;

import domain.Ladder;
import domain.Line;

import java.util.Arrays;

public class ResultView {
    public static void printLadder(Ladder ladder, String[] memberArr) {
        System.out.println();
        System.out.println("실행결과");
        Arrays.stream(memberArr).forEach(str -> System.out.print(str + "   "));
        System.out.println();
        System.out.println(ladder.drawOneLine());
    }
}
