package step2.view;

import step2.domain.Person;
import step2.domain.Persons;
import step2.domain.Point;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private final static String EXIST_BAR_LINE = "|-----";
    private final static String NORMAL_LINE = "|     ";
    private final static String PERSON_NAME_FORMAT = "%6s";
    private final static String SPACE = "     ";

    public static void printLadder(Persons persons, List<Point> lines) {
        System.out.println(printPersons(persons.getPersons()));
        lineDraw(persons.count(), lines);
    }

    private static String printPersons(List<Person> persons){
        return persons.stream()
                      .map(person -> printName(person.getName()))
                      .collect(Collectors.joining());
    }

    private static String printName(String name) {
        return String.format(PERSON_NAME_FORMAT, name);
    }

    private static void lineDraw(int countOfperson, List<Point> lines) {
        lines.forEach(point -> {
            initSpace(point);
            System.out.print(defineLine(point));
            newLine(countOfperson, point);
        });
    }

    private static String defineLine(Point point) {
        return point.right()? EXIST_BAR_LINE : NORMAL_LINE;
    }

    private static void newLine(int countOfperson, Point point) {
        if (point.isLastLine(countOfperson)){
            System.out.println();
        }
    }

    private static void initSpace(Point point) {
        if(point.isFirstLine()){
            System.out.print(SPACE);
        }
    }
}
