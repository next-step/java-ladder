package ladder.view;

import ladder.param.LadderHeightParam;
import ladder.param.PlayerNameParam;
import ladder.param.PlayerNamesParam;
import ladder.param.WinResultsParam;

import java.util.Scanner;

public class InPutView {
    private InPutView() {
        // 생성자 내부 호출 -> 명시적 Exception
        throw new AssertionError();
    }

    private final static Scanner SCANNER = new Scanner(System.in);

    public static PlayerNamesParam askPlayerNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String playerNames = SCANNER.nextLine();

        return new PlayerNamesParam(playerNames);
    }

    public static LadderHeightParam askLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = SCANNER.nextInt();

        return new LadderHeightParam(height);
    }

    public static WinResultsParam askWinResults() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String WinResults = SCANNER.nextLine();

        return new WinResultsParam(WinResults);
    }

    public static void newLineRemove() {
        SCANNER.nextLine();
    }

    public static PlayerNameParam askPlayerWinResults() {
        System.out.println("결과를 보고 싶은 사람은?");
        String playerName = SCANNER.nextLine();

        return new PlayerNameParam(playerName);
    }

    //결과를 보고 싶은 사람은?
}
