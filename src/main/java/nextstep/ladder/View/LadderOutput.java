package nextstep.ladder.View;

import nextstep.ladder.Model.*;

import javax.xml.transform.stream.StreamSource;
import java.util.List;
import java.util.stream.Collectors;

public class LadderOutput {
    private static final String RESULT_TITLE = "실행 결과";
    private static final String DELIMITER = "  ";
    private static final String CONNECT_BRIDGE = "-----|";
    private static final String DIS_CONNECT_BRIDGE = "     |";
    private static final String ENTER = "\n";
    private static final String ALL_PEOPLE = "all";

    public static void printResult(People people, Ladder ladder, Rewards rewards) {
        System.out.println(RESULT_TITLE);
        System.out.println();
        List<Person> People = people.getPeople();
        List<Reward> Rewards = rewards.getRewards();
        System.out.println(People.stream()
                .map(Person::toString)
                .collect(Collectors.joining(DELIMITER)));
        List<Line> Ladder = ladder.getLadder();
        for (Line line : Ladder) {
            printLine(line);
        }
        System.out.println(Rewards.stream()
                .map(Reward::toString)
                .collect(Collectors.joining(DELIMITER)));
    }

    public static void printExecuteResult(String name, People people) {
        System.out.println(RESULT_TITLE);
        if (ALL_PEOPLE.equals(name)) {
            List<Person> People = people.getPeople();
            System.out.println(People.stream()
                    .map(Person::allPeopleToString)
                    .collect(Collectors.joining(ENTER)));
            return;
        }
        Person person = people.getPersonByName(name);
        System.out.println(person.rewardToString());
    }

    private static void printLine(Line line) {
        StringBuilder sb = new StringBuilder();
        line.getLine().forEach(it -> sb.append(convertLineInfoToString(it.isConnect())));
        System.out.println(sb);
    }

    private static String convertLineInfoToString(Boolean lineInfo) {
        if (lineInfo) {
            return CONNECT_BRIDGE;
        }
        return DIS_CONNECT_BRIDGE;
    }

}
