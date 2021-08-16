package step2.inputView;

import step2.domain.game.GameData;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner SC = new Scanner(System.in);

    private static final String REGEX = ",";

    public static GameData makeGameData() {
        List<String> names = getNames();
        int height = getHeight();
        return GameData.of(names, height);
    }

    private static List<String> getNames() {
        showGetNamesText();
        String line = SC.nextLine();
        return Arrays.stream(split(line))
            .collect(Collectors.toList());
    }

    private static String[] split(String input) {
        return input.split(REGEX);
    }

    private static void showGetNamesText() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    private static int getHeight() {
        showGetHeightText();
        return SC.nextInt();
    }

    private static void showGetHeightText() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
    }
}
