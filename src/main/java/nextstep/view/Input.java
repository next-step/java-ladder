package nextstep.view;

import nextstep.domain.Players;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {

    private static final String INPUT_NAME_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final Scanner sc = new Scanner(System.in);

    public static Players getUserName() {
        System.out.println(INPUT_NAME_MESSAGE);
        String line = sc.nextLine();
        String[] str = line.split(",");

        List<String> playerNames = new ArrayList<>();
        for (int i = 0; i < str.length; i++) {
            playerNames.add(str[i]);
        }

        return new Players(playerNames);
    }

    public static int getHeight() {
        System.out.println(INPUT_HEIGHT_MESSAGE);
        return sc.nextInt();
    }
}
