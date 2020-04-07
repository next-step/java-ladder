package ladder;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LadderApplication {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String usersInput = scanner.nextLine();
        List<String> users = Arrays.asList(usersInput.split(","));

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int ladderMaxHeight = scanner.nextInt();

        System.out.println("실행결과");

        System.out.println(users.stream().collect(Collectors.joining(" ")));
    }
}
