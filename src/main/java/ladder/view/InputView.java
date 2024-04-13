package ladder.view;

import ladder.domain.Player;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static List<Player> scanPlayersNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String line = scanner.nextLine();
        if (line == null || line.isBlank()) {
            throw new IllegalArgumentException("입력은 공백일 수 없습니다.");
        }
        return Arrays.stream(line.split(","))
                .map(String::trim)
                .map(Player::new)
                .collect(Collectors.toUnmodifiableList());
    }

    public static int scanHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }
}
