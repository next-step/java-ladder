package nextstep.ladder.view;

import nextstep.ladder.domain.Player;
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

}
