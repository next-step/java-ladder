package nextstep.ladder.view;

import nextstep.ladder.domain.*;
import nextstep.ladder.dto.LadderResponseDto;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String PRINT_ALL = "all";
    private static final String NAME_FORMAT = "%6s";
    private static final String SPACE_FORMAT = "     ";
    private static final String ROW_LINE = "|-----";
    private static final String BLANK_LINE = "|     ";

    public static void printLadder(LadderResponseDto ladderResponseDto) {
        printNames(ladderResponseDto.getLadderGameInfo().getPersons());
        List<LadderLine> ladderLines = ladderResponseDto.getLadderLines();

        for (LadderLine ladderLine : ladderLines) {
            List<Point> points = ladderLine.getPoints();
            StringBuilder stringBuilder = new StringBuilder(SPACE_FORMAT);
            for (Point point : points) {
                stringBuilder.append(printDirection(point, stringBuilder));
            }
            System.out.println(stringBuilder);
        }
        printResult(ladderResponseDto.getLadderGameInfo().getResults());
    }

    private static String printDirection(Point point, StringBuilder stringBuilder) {
        if(point.getDirection().isRight()) {
            return ROW_LINE;
        }
        return BLANK_LINE;
    }

    private static void printResult(List<Result> results) {
        String formatString = results.stream()
                .map(result -> format(result.getResult()))
                .collect(Collectors.joining());
        System.out.println(formatString);
    }

    private static void printNames(List<Person> persons) {
        String names = persons.stream()
                .map(Person::getName)
                .map(name -> format(name))
                .collect(Collectors.joining());
        System.out.println(names);
    }

    private static String format(String name) {
        return String.format(NAME_FORMAT, name);
    }

    public static void printOutput(List<Integer> linePosition, String name, LadderResponseDto ladderResponseDto) {
        LadderGameInfo ladderGameInfo = ladderResponseDto.getLadderGameInfo();
        printOutputByName(linePosition, name, ladderGameInfo);
    }

    private static void printOutputByName(List<Integer> linePosition, String name, LadderGameInfo ladderGameInfo) {
        List<Person> persons = ladderGameInfo.getPersons();
        List<Result> results = ladderGameInfo.getResults();
        if (name.equals(PRINT_ALL)) {
            for (int i = 0; i < persons.size(); i++) {
                System.out.println(persons.get(i).getName() + " : " + results.get(linePosition.get(i)).getResult());
            }
            return;
        }
        System.out.println(name + " : " + results.get(linePosition.get(0)).getResult());
    }
}
