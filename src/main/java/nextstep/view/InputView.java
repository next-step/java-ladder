package nextstep.view;

import nextstep.domain.ladder.Height;
import nextstep.domain.player.Player;
import nextstep.domain.player.Players;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String NAME_DELIMITER = ",";

    public static Players getPlayersName() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String playersName = scanner.nextLine();
        List<Player> players = Arrays.stream(playersName.split(NAME_DELIMITER))
                .map(Player::new)
                .collect(Collectors.toList());
        return new Players(players);
    }

    public static Height getMaxLadderHeight(){
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = scanner.nextInt();
        return new Height(height);
    }
}
