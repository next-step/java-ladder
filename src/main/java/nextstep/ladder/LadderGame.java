package nextstep.ladder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {

    private static final int MAX_NAME_LENGTH = 5;

    public static void main(String[] args) {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String input = "pobi,honux,crong,jk";
        List<String> users = Arrays.stream(input.split(","))
                .collect(Collectors.toList());
        int countOfPerson = users.size();

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = 5;

        System.out.println("실행결과");
        String collect = users.stream()
                .map(name -> String.format("%5s", name))
                .collect(Collectors.joining(" "));

        System.out.println(collect);
        for (int i = 0; i < height; i++) {
            System.out.println(" ".repeat(MAX_NAME_LENGTH) + "|" + "-".repeat(MAX_NAME_LENGTH) + "|" + "-".repeat(MAX_NAME_LENGTH) + "|" + "-".repeat(MAX_NAME_LENGTH) + "|");
        }
    }
}
