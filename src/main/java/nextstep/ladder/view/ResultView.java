package nextstep.ladder.view;

import nextstep.ladder.domain.*;

import java.util.List;

public class ResultView {

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
        StringBuilder sb = new StringBuilder();

        List<Person> people = ladder.people().value();
        for (int i = 0; i < people.size(); i++) {
            String name = people.get(i).name();

            if (i == 0) {
                sb.append(name);
                continue;
            }

            for (int j = 0; j < 6 - name.length(); j++) {
                sb.append(' ');
            }
            sb.append(name);
        }
        return sb.toString();
    }

    private static void printLines(Ladder ladder) {
        System.out.println(makeLines(ladder));
    }

    private static String makeLines(Ladder ladder) {
        StringBuilder sb = new StringBuilder();
        Lines lines = ladder.lines();
        People people = ladder.people();
        int firstNameLength = people.firstNameLength();

        for (Line line : lines.value()) {
            List<Boolean> points = line.points();

            for (int j = 0; j < points.size(); j++) {
                if (j == 0) {
                    for (int i = 0; i < firstNameLength; i++) {
                        sb.append(" ");
                    }
                    sb.append("|");
                    continue;
                }

                if (points.get(j)) {
                    sb.append("-----");
                } else {
                    sb.append("     ");
                }
                sb.append("|");
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
