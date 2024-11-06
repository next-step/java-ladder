package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.domain.util.RandomLineGenerator;
import ladder.exception.InvalidNameException;
import ladder.exception.LineException;
import ladder.exception.PlayersCountException;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public Players inputPlayerNamesToPlayers() {
        try {
            return new Players(inputPlayers());
        } catch (InvalidNameException  e) {
            System.out.println(e.getMessage());
            return inputPlayerNamesToPlayers();
        }
    }
    public Ladder inputVerticalSizeToLadder(Players players) {
        try {
            return new Ladder(players, inputVerticalSize(), new RandomLineGenerator());
        } catch (PlayersCountException | LineException e) {
            System.out.println(e.getMessage());
            return inputVerticalSizeToLadder(players);
        }
    }

    private String inputPlayers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return scanner.nextLine();
    }

    private int inputVerticalSize() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int inputVerticalSize = scanner.nextInt();
        scanner.nextLine();
        return inputVerticalSize;
    }
}
