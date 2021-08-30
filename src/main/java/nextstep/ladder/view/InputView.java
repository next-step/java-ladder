package nextstep.ladder.view;

import nextstep.ladder.domain.impl.Player;
import nextstep.ladder.domain.impl.WinningPrize;
import nextstep.ladder.utils.StringUtils;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    public static final String ALL_PLAYER_TOKEN = "all";
    private static Scanner SCANNER = new Scanner(System.in);

    public static List<Player> inputPlayerNames() {
        return StringUtils.splitWithComma(SCANNER.nextLine()).stream()
                .map(Player::from)
                .collect(Collectors.toList());
    }

    public static int inputLadderHeight() {
        return Integer.parseInt(SCANNER.nextLine());
    }

    public static List<WinningPrize> inputWinningPrizes() {
        return StringUtils.splitWithComma(SCANNER.nextLine()).stream()
                .map(WinningPrize::new)
                .collect(Collectors.toList());
    }

    public static List<Player> inputPlayerNameForResult(List<Player> players) {
        String input = SCANNER.nextLine();
        if (input.equals(ALL_PLAYER_TOKEN)) {
            return players;
        }
        return StringUtils.splitWithComma(input).stream()
                .map(Player::from)
                .collect(Collectors.toList());
    }
}
