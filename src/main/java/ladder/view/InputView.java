package ladder.view;

import ladder.domain.line.Height;
import ladder.domain.player.Player;
import ladder.domain.player.Players;
import ladder.utils.NameSplitter;

import java.util.Scanner;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static Players readPlayers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        return NameSplitter.split(scanner.nextLine()).stream()
                .map(Player::create)
                .collect(collectingAndThen(toList(), Players::create));
    }

    public static Height readHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");

        return Height.valueOf(Integer.parseInt(scanner.nextLine()));
    }
}
