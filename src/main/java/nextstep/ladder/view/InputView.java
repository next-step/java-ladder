package nextstep.ladder.view;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public List<String> requestPlayers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String names = scanner.nextLine();
        System.out.println();
        return Stream.of(names.split(","))
            .map(String::trim)
            .collect(Collectors.toList());
    }

    public List<String> requestPrize() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String names = scanner.nextLine();
        System.out.println();
        return Stream.of(names.split(","))
            .map(String::trim)
            .collect(Collectors.toList());
    }

    public int requestHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = Integer.parseInt(scanner.nextLine());
        System.out.println();
        return height;
    }

    public String requestResultOfPlayer() {
        System.out.println("결과를 보고 싶은 사람은?");
        String player = scanner.nextLine();
        System.out.println();
        return player;
    }
}
