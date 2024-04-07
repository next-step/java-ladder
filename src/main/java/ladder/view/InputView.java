package ladder.view;

import ladder.util.StringSplitter;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static List<String> getPlayersNames(){
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String playersNamesStrings = SCANNER.nextLine();
        return StringSplitter.splitWithComma(playersNamesStrings);
    }

    public static int getLadderHeight(){
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return SCANNER.nextInt();
    }
}
