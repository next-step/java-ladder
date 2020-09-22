package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Users;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요");

        String personsRaw = scanner.nextLine();
        Users users = Users.of(personsRaw);

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = Integer.parseInt(scanner.nextLine());

        Ladder ladder = Ladder.of(users.countOfUsers(), height);

        System.out.println(ladder);

    }
}
