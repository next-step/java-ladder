package nextstep.ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private List<String> userNames;
    private int ladderHeight;
    private final Scanner sc;

    public InputView() {
        this.sc = new Scanner(System.in);
    }

    public void inputNames(){
        System.out.println("참여랑 사람 이름을 입력 하세요. (이름은 쉼표(,)로 구분하세요.");
        String input = sc.nextLine();

        String[] split = input.split(",");
        userNames = Arrays.stream(split)
                .collect(Collectors.toList());
    }

    public void inputHeight(){
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        ladderHeight = sc.nextInt();
    }

    public List<String> getUserNames() {
        return userNames;
    }

    public int getLadderHeight() {
        return ladderHeight;
    }
}
