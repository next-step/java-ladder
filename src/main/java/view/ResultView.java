package view;

import domain.Ladder;

import java.util.Arrays;

public class ResultView {
    public static void printLadder(Ladder ladder, String[] memberArr) {
        System.out.println();
        System.out.println("사다리 결과");
        System.out.println();
        Arrays.stream(memberArr).forEach(str -> System.out.print(str + "   "));
        System.out.println();
        System.out.println(ladder.drawLadder());
    }

    public static void printResult(String[] result) {
        Arrays.stream(result).forEach(str -> System.out.print(str + "   "));
        System.out.println();
    }

    public static void printMemberResult(String s) {
        System.out.println();
        System.out.println("실행 결과");
        System.out.println(s);
    }

    public static void printAllResult(String result) {
        String stringArr[] = result.split("\n");
        System.out.println();
        System.out.println("실행 결과");
        for(String s : stringArr) {
            System.out.println(s);
        }
    }
}
