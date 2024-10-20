package ladder.view;

import ladder.Name;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public List<Name> getNamesFromUser() {
        String inputLine = scanner.nextLine();

        String[] split = inputLine.split(",");
        return Arrays.stream(split)
                .filter(s -> !s.isBlank())
                .map(Name::new)
                .collect(Collectors.toUnmodifiableList());
    }
}
