package ladder.step2.view.input;

import ladder.step2.domain.LadderResults;
import ladder.step2.dto.LadderHeightDTO;
import ladder.step2.domain.Players;
import ladder.step2.dto.PlayersDTO;
import ladder.step2.utils.StringUtils;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String PLAYER_NAMES_INPUT_MESSAGE = "\n참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String LADDER_HEIGHT_INPUT_MESSAGE = "\n최대 사다리 높이는 몇 개인가요?";
    private static final String INPUT_EXCEPTION_MESSAGE = "올바른 입력 형식이 아닙니다. 다시 입력해주세요.";
    private static final String LADDER_RESULTS_INPUT_MESSAGE = "\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String TARGET_PLAYER_INPUT_MESSAGE = "\n결과를 보고 싶은 사람은? (all 입력 시, 모든 결과 출력 후 프로그램 종료)";
    
    public static Players inputPlayerNames() {
        try {
            System.out.println(PLAYER_NAMES_INPUT_MESSAGE);
            final String input = SCANNER.nextLine();
            checkBlankException(input);
            return new Players(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputPlayerNames();
        }
    }
    
    public static LadderResults ladderResults(PlayersDTO playersDTO) {
        try {
            System.out.println(LADDER_RESULTS_INPUT_MESSAGE);
            final String input = SCANNER.nextLine();
            checkBlankException(input);
            return new LadderResults(input, playersDTO.size());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return ladderResults(playersDTO);
        }
    }
    
    public static LadderHeightDTO inputLadderHeight() {
        try {
            System.out.println(LADDER_HEIGHT_INPUT_MESSAGE);
            final String input = SCANNER.nextLine();
            checkBlankException(input);
            return new LadderHeightDTO(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputLadderHeight();
        }
    }
    
    public static String inputTargetPlayer() {
        System.out.println(TARGET_PLAYER_INPUT_MESSAGE);
        final String input = SCANNER.nextLine();
        System.out.println();
        return input;
    }
    
    private static void checkBlankException(final String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException(INPUT_EXCEPTION_MESSAGE);
        }
    }
}
