package nextstep.ladder.ui;

import nextstep.ladder.domain.player.Player;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);
    private static final String DELIMITER_COMMA = ",";

    public List<Player> getPlayersName() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        String inputPlayers = scanner.nextLine();

        return Arrays.stream(splitByDelimiter(inputPlayers))
                     .map(Player::new)
                     .collect(Collectors.toList());
    }

    public int getLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");

        return scanner.nextInt();
    }

    private String[] splitByDelimiter(String text) {
        return text.split(DELIMITER_COMMA);
    }

}
