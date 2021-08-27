package nextstep.ladder.view;

import nextstep.ladder.domain.Player;
import nextstep.ladder.domain.winningPrize.WinningPrizes;
import nextstep.ladder.utils.StringUtils;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static Scanner SCANNER = new Scanner(System.in);

    public static List<Player> inputPlayerNames() {
        return StringUtils.splitWithComma(SCANNER.nextLine()).stream()
                .map(Player::from)
                .collect(Collectors.toList());
    }

    public static int inputLadderHeight() {
        return SCANNER.nextInt();
    }

    public static WinningPrizes inputWinningPrizes() {
        return WinningPrizes.from(SCANNER.nextLine());
    }

    public static List<Player> inputPlayerNameForResult(List<Player> players) {
        SCANNER = new Scanner(System.in);
        String input = SCANNER.nextLine();
        if (input.equals("all")) {
            return players;
        }
        return StringUtils.splitWithComma(input).stream()
                .map(Player::from)
                .collect(Collectors.toList());
    }
}
