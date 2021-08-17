package step4.inputView;

import step4.domain.ladder.LadderData;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner SC = new Scanner(System.in);

    private static final String REGEX = ",";

    public static LadderData makeGameData() {
        List<String> names = getNames();
        int height = getHeight();
        return LadderData.of(names, height);
    }

    public static List<String> getNames() {
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

    public static int getHeight() {
        showGetHeightText();
        return Integer.parseInt(SC.nextLine());
    }

    private static void showGetHeightText() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
    }

    public static List<String> getResults() {
        showGetResultText();
        String line = SC.nextLine();
        return Arrays.stream(split(line))
            .collect(Collectors.toList());
    }

    private static void showGetResultText() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
    }

    public static String getNameOf() {
        showGetNameOf();
        return SC.nextLine();
    }

    private static void showGetNameOf() {
        System.out.println("결과를 보고 싶은 사람은?");
    }
}
