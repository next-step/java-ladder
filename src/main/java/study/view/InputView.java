package study.view;

import study.core.PlayerName;
import study.core.Prize;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public List<PlayerName> inputNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String[] names = SCANNER.nextLine().split(",");
        System.out.println();
        return Arrays.stream(names)
                .map(String::trim)
                .peek(name -> {
                    if (name.equals("all")) {
                        throw new IllegalArgumentException("all은 이름으로 사용할 수 없습니다.");
                    }
                })
                .map(PlayerName::new)
                .collect(Collectors.toList());
    }

    public int inputHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = SCANNER.nextInt();
        SCANNER.nextLine();
        System.out.println();
        return height;
    }

    public List<Prize> inputResult() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String[] results = SCANNER.nextLine().split(",");
        System.out.println();
        return Arrays.stream(results)
                .map(Prize::new)
                .collect(Collectors.toList());
    }

    public PlayerName inputName() {
        System.out.println();
        System.out.println("결과를 보고 싶은 사람은?");
        return new PlayerName(SCANNER.nextLine());
    }

}
