package study.view;

import study.core.PlayerName;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner sc = new Scanner(System.in);

    public List<PlayerName> inputNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String[] names = sc.nextLine().split(",");
        return Arrays.stream(names)
                .map(PlayerName::new)
                .collect(Collectors.toList());
    }

    public int inputHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = sc.nextInt();
        sc.nextLine();
        return height;
    }

}
