package step2.view;

import step2.domain.ExecutionResults;
import step2.dto.Height;
import step2.dto.InputDto;
import step2.dto.Players;

import java.util.Scanner;

public class InputView {
    private static final String DELIMITER = ",";

    private static final Scanner scanner = new Scanner(System.in);

    public InputDto inputValues() {
        System.out.printf("참여할 사람 이름을 입력하세요. (이름은 쉼표(%s)로 구분하세요)\n", DELIMITER);
        final String[] players = scanner.nextLine().split(DELIMITER);

        System.out.println("\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        final String[] results = scanner.nextLine().split(DELIMITER);
        validateResult(players.length, results.length);

        return new InputDto(new Players(players), new ExecutionResults(results));
    }

    private void validateResult(int lengthOfPlayers, int lengthOfResults) {
        if (lengthOfPlayers != lengthOfResults) {
            throw new RuntimeException("실행 결과는 사람 수와 동일해야 합니다.");
        }
    }

    public Height inputHeight() {
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");
        return new Height(Integer.parseInt(scanner.nextLine()));
    }

}
