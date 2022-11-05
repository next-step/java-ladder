package ladder;

import java.util.List;
import java.util.Map;

public class OutputView {
    public static void printLadder(Persons persons, int ladderHeight, Ladder aladder, Results results) {
        List<LadderLine> ladder = aladder.getLadder();

        System.out.println("\n실행결과\n");
        for (Person person : persons.getPersons()) {
            System.out.printf("%7s", person.getName());
        }
        System.out.println();
        for (int i = 0; i < ladderHeight; i++) {
            LadderLine line = ladder.get(i);
            System.out.printf("%7s", "|");
            for (int j = 1; j < persons.countOfPersons(); j++) {
                if (line.isConnected(j - 1, j)) {
                    System.out.printf("%s%s", "------", "|");
                } else {
                    System.out.printf("%7s", "|");
                }
            }
            System.out.println();
        }
        for (Result result : results.getResults()) {
            System.out.printf("%7s", result.getResult());
        }
        System.out.println();
    }

    public static void printResult(Map<Person, Result> results) {
        results.forEach((key, value) -> System.out.printf("%s : %s\n", key.getName(), value.getResult()));
    }
}
