package nextstep.ladder.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    private static final String INPUT_PLAYER_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

    public static String inputNames() {
        return inputWithText(INPUT_PLAYER_NAMES);
    }

    private static String inputWithText(String text) {
        System.out.println(text);
        return input();
    }

    private static String input() {
        try {
            return BR.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
