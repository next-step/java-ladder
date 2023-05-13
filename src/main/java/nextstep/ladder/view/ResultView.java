package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Person;

import java.util.List;

public class ResultView {

    static void printPeopleInputCommand() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    static void printHeightInputCommand() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
    }

    public static void printResult(Ladder ladder) {
        System.out.println("실행결과");
        System.out.println();

        printLadder(ladder);

        System.out.println("ladder.lines() = " + ladder.lines());
    }

    private static void printLadder(Ladder ladder) {
        printNames(ladder);
        printLines(ladder);
    }

    private static void printNames(Ladder ladder) {
        System.out.println(makeNames(ladder));
    }

    private static StringBuilder makeNames(Ladder ladder) {
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
        return sb;
    }

    private static void printLines(Ladder ladder) {


    }
}
