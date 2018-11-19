package view;

import domain.Ladder;
import domain.InputTagGroup;
import domain.ResultTagGroup;

import java.util.Scanner;

public class ResultView {
    private static final String ALL = "all";

    public static void ladderResult() {
        System.out.println("사다리 결과");
    }


    public static void printNameTags(InputTagGroup nameTagGroup) {
        nameTagGroup.getNameTags().stream().forEach(System.out::print);
        System.out.println();
    }

    public static void printResultNameTags(ResultTagGroup resultTagGroup) {
        resultTagGroup.getNameTags().stream().forEach(System.out::print);
        System.out.println();
    }

    public static void printFinalResult(InputTagGroup nameTagGroup, ResultTagGroup resultTagGroup) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("결과를 보고 싶은 사람은?");
            String name = sc.nextLine();

            System.out.println("실행 결과");
            if (name.equals(ALL)) {
                nameTagGroup.getAllFinalResult(resultTagGroup).forEach(System.out::println);
                break;
            }
            System.out.println(nameTagGroup.getFinalResult(name, resultTagGroup));

        }
    }

    public static void printLadder(Ladder ladder) {
        ladder.getLines().forEach(System.out::println);
    }
}
