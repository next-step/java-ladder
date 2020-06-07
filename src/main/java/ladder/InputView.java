package ladder;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String PLAYER_NAME_DELIMITER = ",";

    private InputView() {}

    public static Players askPlayerNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        List<PlayerName> playerNames = parsePlayerNames(SCANNER.nextLine());
        return Players.of(playerNames);
    }

    private static List<PlayerName> parsePlayerNames(String namesStr) {
        return Arrays.stream(namesStr.split(PLAYER_NAME_DELIMITER))
                .map(name -> PlayerName.of(name.trim()))
                .collect(Collectors.toList());
    }

    public static LadderHeight askLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return LadderHeight.of(SCANNER.nextInt());
    }
}
