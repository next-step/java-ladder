package nextstep.ladder.view;

import nextstep.ladder.Persons;

import java.util.List;

public class ResultView {

    public static void printResult(Persons persons) {
        System.out.println("실행 결과");

        printPersonsName(persons.getPersonsName());
    }

    private static void printPersonsName(List<String> names) {
        for (String name : names) {
            System.out.printf("%" + -(names.size() + 1) + "s", name);
        }
        System.out.println();
    }

    public static void printLadder(String ladder) {
        System.out.println(ladder);
    }
}
