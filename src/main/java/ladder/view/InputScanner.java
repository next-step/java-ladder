package ladder.view;

import ladder.util.StringUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputScanner {
    private static final String DELIMITER = ",";
    private final Scanner scanner;

    public InputScanner() {
        this.scanner = new Scanner(System.in);
    }

    public List<String> scannerPlayers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String inputPlayers = scanner.nextLine();
        return Arrays.asList(StringUtil.split(inputPlayers.trim(), DELIMITER));
    }

    public List<String> scannerPrizes() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String inputPrize = scanner.nextLine();
        return Arrays.asList(StringUtil.split(inputPrize.trim(), DELIMITER));
    }

    public int scannerLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }

    public String scannerPlayerNameForPrize() {
        System.out.println("결과를 보고 싶은 사람은?");
        return scanner.next();
    }
}
