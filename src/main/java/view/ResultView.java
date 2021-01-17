package view;

import domain.Ladder;
import domain.Line;
import domain.PersonList;

public class ResultView {
    private static String printName(String name) {
        return String.format("%5s", name);
    }

    private static void printNames(PersonList personList) {
        personList.getList()
                .stream()
                .map(person -> printName(person.getName()) + " ")
                .forEach(System.out::print);
    }

    private static void printPoint(boolean point) {
        String printMessage = point ? "-----" : "     ";
        System.out.print(printMessage);
        System.out.print("|");
    }

    private static void printLine(Line line) {
        System.out.print("   |");
        line.getLine()
                .forEach(point -> printPoint(point));
        System.out.println();
    }

    public static void ladder(PersonList personList, Ladder ladder) {
        System.out.println("실행결과");
        System.out.println();

        printNames(personList);

        System.out.println();

        ladder.getLadder()
                .forEach(line -> printLine(line));
    }
}
