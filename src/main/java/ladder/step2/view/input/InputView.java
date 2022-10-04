package ladder.step2.view.input;

import ladder.step2.domain.Players;
import ladder.step2.utils.InputUtils;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String PLAYER_NAMES_INPUT_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String LADDER_HEIGHT_INPUT_MESSAGE = "\n최대 사다리 높이는 몇 개인가요?";
    
    public static Players inputPlayerNames() {
        try {
            System.out.println(PLAYER_NAMES_INPUT_MESSAGE);
            return InputUtils.getPlayers(SCANNER.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputPlayerNames();
        }
    }
    
    public static int inputLadderHeight() {
        try {
            System.out.println(LADDER_HEIGHT_INPUT_MESSAGE);
            return InputUtils.getLadderHeight(SCANNER.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputLadderHeight();
        }
    }
}
