package nextstep.mission;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputScanner {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String DELIMITER = ",";

    public static List<Participant> getUsers() {
        return getUsers(SCANNER.next());
    }

    public static List<Participant> getUsers(String text) {
        return Arrays.stream(text.split(DELIMITER))
                .map(Participant::new)
                .collect(Collectors.toList());
    }
}
