package nextstep.ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String NAME_DELIMITER = ",";
    private static final int MAX_NAME_LENGTH = 5;

    public List<String> askNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        try {
            return toNames(SCANNER.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        return askNames();
    }

    private List<String> toNames(String input) {
        if(input == null || input.isBlank()) {
            throw new IllegalArgumentException("참여할 사람 이름을 입력하세요");
        }

        return Arrays.stream(input.split(NAME_DELIMITER))
                .map(String::trim)
                .filter(name -> name.length() <= MAX_NAME_LENGTH)
                .collect(toList());
    }

    public int askLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");

        try {
            return Integer.parseInt(SCANNER.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }

        return askLadderHeight();
    }

}
