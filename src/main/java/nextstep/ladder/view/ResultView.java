package nextstep.ladder.view;

import nextstep.ladder.domain.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {

    private static final int BEGIN_INDEX = 0;
    private static final int NAME_SPACE = 6;

    static void printPeopleInputCommand() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    static void printHeightInputCommand() {
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");
    }

    public static void printResult(Ladder ladder) {
        System.out.println("\n실행결과\n");
        printLadder(ladder);
    }

    private static void printLadder(Ladder ladder) {
        printNames(ladder);
        printLines(ladder);
    }

    private static void printNames(Ladder ladder) {
        System.out.println(makeNames(ladder));
    }

    private static String makeNames(Ladder ladder) {
        List<Person> people = ladder.people().value();

        return IntStream.range(BEGIN_INDEX, people.size())
                .mapToObj(i -> {
                    String name = people.get(i).name();

                    if (BEGIN_INDEX == i) {
                        return name;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(" ".repeat(NAME_SPACE - name.length()));
                    sb.append(name);
                    return sb.toString();
                })
                .collect(Collectors.joining());
    }

    private static void printLines(Ladder ladder) {
        System.out.println(makeLines(ladder));
    }

    private static String makeLines(Ladder ladder) {
        People people = ladder.people();
        Lines lines = ladder.lines();

        return lines.value().stream()
                .map(line -> {
                    StringBuilder sb = new StringBuilder();
                    IntStream.range(BEGIN_INDEX, line.points().size())
                            .mapToObj(idx -> generatePointString(people, line, idx)
                            )
                            .forEach(sb::append);

                    sb.append("\n");
                    return sb.toString();
                })
                .collect(Collectors.joining());
    }

    private static String generatePointString(People people, Line line, int idx) {
        if (BEGIN_INDEX == idx) {
            return " ".repeat(people.firstPersonNameLength()) + "|";
        }
        return line.points().get(idx) ? "-----|" : "     |";
    }

}

