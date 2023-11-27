package step2.view;

import step2.model.Player;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String SERARATOR = ",";

    public static List<Player> inputPlayers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String players = scanner.nextLine();

        return Arrays.stream(players.split(SERARATOR))
                .map(Player::new)
                .collect(Collectors.toList());
    }

    public static int inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int lineHeight = scanner.nextInt();
        validateLadderHeightInput(lineHeight);
        return lineHeight;
    }

    private static void validateLadderHeightInput(int lineHeight) {
        if (lineHeight == 0 || lineHeight < 0) {
            throw new IllegalArgumentException("사다리 높이가 0이거나 음수일 수 없습니다.");
        }
    }
}
