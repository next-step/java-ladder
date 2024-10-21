package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public List<String> getNamesFromUser() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String inputLine = SCANNER.nextLine();

        return Arrays.stream(inputLine.split(","))
                .map(String::trim)
                .filter(s -> !s.isBlank())
                .collect(Collectors.toUnmodifiableList());
    }

    public int getHeightFromUser() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        String inputString = SCANNER.nextLine();
        return Integer.parseInt(inputString);
    }
}
