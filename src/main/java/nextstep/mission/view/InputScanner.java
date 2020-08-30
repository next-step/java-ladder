package nextstep.mission.view;

import nextstep.mission.domain.Participant;
import nextstep.mission.domain.Participants;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputScanner {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String DELIMITER = ",";

    public static String printMessageAndSelectResult(String message) {
        System.out.println(message);
        return selectResult();
    }

    public static String selectResult() {
        return SCANNER.next();
    }

    public static List<String> printMessageAndGetResults(String message) {
        System.out.println(message);
        return getResults();
    }

    public static List<String> getResults() {
        return getResults(SCANNER.next());
    }

    public static List<String> getResults(String text) {
        return Arrays.stream(text.split(DELIMITER))
                .collect(Collectors.toList());
    }

    public static Participants printMessageAndGetUsers(String message) {
        System.out.println(message);
        return getUsers();
    }

    public static Participants getUsers() {
        return getUsers(SCANNER.next());
    }

    public static Participants getUsers(String text) {
        return new Participants(
                Arrays.stream(text.split(DELIMITER))
                        .map(Participant::new)
                        .collect(Collectors.toList())
        );
    }

    public static int printMessageAndGetHeight(String message) {
        System.out.println(message);
        return getHeight();
    }

    public static int getHeight() {
        return SCANNER.nextInt();
    }
}
