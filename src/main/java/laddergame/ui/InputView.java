package laddergame.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static java.util.stream.Collectors.toCollection;

public class InputView {
    private static final String INPUT_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private static Scanner sc;
    static {
        sc = new Scanner(System.in);
    }

    public ArrayList<String> inputNames() {
        System.out.println(INPUT_NAMES);
        String input = sc.nextLine();
        String names[] = input.split(",");
        return Arrays.stream(names)
                .collect(toCollection(ArrayList::new));
    }

    public int inputHeight() {
        System.out.println(INPUT_HEIGHT);
        return Integer.parseInt(sc.nextLine());
    }

    public void close() {
        sc.close();
    }
}
