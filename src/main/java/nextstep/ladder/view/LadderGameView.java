package nextstep.ladder.view;

import nextstep.ladder.domain.LadderGameViewHelper;

import java.util.List;
import java.util.Scanner;

public class LadderGameView {

    public List<String> inputPlayers() {
        Scanner scanner = new Scanner(System.in);
        String userNameInput = scanner.nextLine();
        return LadderGameViewHelper.parseUserNameInput(userNameInput);
    }
}
