package nextstep.ladder.view;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public List<String> requestPlayers(){
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String names = scanner.nextLine();
        System.out.println();
        return Stream.of(names.split(","))
            .map(String::trim)
            .collect(Collectors.toList());
    }

    public int requestHeight(){
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = scanner.nextInt();
        System.out.println();
        return height;
    }
}
