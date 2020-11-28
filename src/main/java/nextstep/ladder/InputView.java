package nextstep.ladder;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public static List<String> splitName(String namesLine) {
        return Arrays.asList(namesLine.split(","));
    }

    public List<String> requestPlayers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return splitName(new Scanner(System.in).nextLine());
    }

    public int requestHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return new Scanner(System.in).nextInt();
    }
}
