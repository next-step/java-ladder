package nextstep.ladder.view;

import java.util.stream.Collectors;

import nextstep.ladder.Ladder;
import nextstep.ladder.LadderRow;
import nextstep.ladder.Persons;
import nextstep.ladder.Point;
import nextstep.ladder.Result;
import nextstep.ladder.Results;

import java.util.List;

public class ResultView {

    public static final String COLUMN = "|" ;
    public static final String ROW = "-" ;

    public static void printResult(Results results, int endIndex){
        System.out.println("사다리 결과");
        System.out.println(results.getResults().get(endIndex).getResult());
    }

    public static void printPerson(Persons persons) {
        System.out.println("사다리 결과");
        printPersonsName(persons.getPersonsName());
    }

    private static void printPersonsName(List<String> names) {
        for (String name : names) {
            System.out.printf("%" + -(names.size() + 1) + "s", name);
        }
        System.out.println();
    }

    public static void printLadder(List<LadderRow> ladder) {
        System.out.println(ladder.stream()
                .map(t -> drawLadderRow(t.getPoints()))
                .collect(Collectors.joining("\n"))
        );
    }

    public static void printLadderResults(List<Result> resultList) {
        System.out.println(resultList.stream()
                .map(Result::getResult)
                .collect(Collectors.joining(" ".repeat(resultList.size())))
        );
    }

    public static String drawLadderRow(List<Point> pointList) {
        StringBuilder stringBuilder = new StringBuilder();
        pointList.stream()
                .map(t -> drawLadderRowStem(t, pointList.size()))
                .forEach(t -> {
                    stringBuilder.append(COLUMN);
                    stringBuilder.append(t);
                });
        return stringBuilder.toString();
    }

    private static String drawLadderRowStem(Point point, int pointsSize) {
        if (point.isRightConnected()) {
            return ROW.repeat(pointsSize);
        }
        return " ".repeat(pointsSize);
    }

    public static void printAllResults(Persons persons, Results results, Ladder ladder) {
        for (int i = 0; i < persons.personListSize(); i++) {
            System.out.println("실행 결과");
            System.out.println(persons.getPersonNameByIndex(i) + " : " + results.getResultByIndex(ladder.getResultIndex(i)));
        }
    }
}
