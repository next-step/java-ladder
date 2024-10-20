package ladder.view;

import ladder.Height;
import ladder.Name;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public List<Name> getNamesFromUser() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String inputLine = scanner.nextLine();

        return Arrays.stream(inputLine.split(","))
                .map(String::trim)
                .filter(s -> !s.isBlank())
                .map(Name::new)
                .collect(Collectors.toUnmodifiableList());
    }

    public Height getHeightFromUser() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        String inputString = scanner.nextLine();
        return new Height(Integer.parseInt(inputString));
    }
}
