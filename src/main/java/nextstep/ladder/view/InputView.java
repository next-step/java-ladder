package nextstep.ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private List<String> userNames;
    private int ladderHeight;
    private final Scanner sc;

    private static final String INPUT_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개 인가요?";
    private static final String INPUT_USER_NAMES_MESSAGE = "참여한 사람 이름을 입력 하세요. (이름은 쉼표(,)로 구분 하세요.";

    public InputView() {
        this.sc = new Scanner(System.in);
    }

    public void inputNames(){
        System.out.println(INPUT_USER_NAMES_MESSAGE);
        String input = sc.nextLine();

        String[] split = input.split(",");
        userNames = Arrays.stream(split)
                .collect(Collectors.toList());
        System.out.println();
    }

    public void inputHeight(){
        System.out.println(INPUT_HEIGHT_MESSAGE);
        ladderHeight = sc.nextInt();
        System.out.println();
    }

    public List<String> getUserNames() {
        return userNames;
    }

    public int getLadderHeight() {
        return ladderHeight;
    }
}
