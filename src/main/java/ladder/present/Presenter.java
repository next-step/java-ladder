package ladder.present;

import ladder.control.Preferences;
import ladder.domain.Ladder;
import ladder.domain.User;
import ladder.domain.Users;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Presenter {
    private final Scanner scanner;

    public Presenter() {
        this.scanner = new Scanner(System.in);
    }

    public Users users() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String s = scanner.nextLine();
        String[] split = s.split(",");
        List<User> collect = Arrays.stream(split).map(User::new).collect(Collectors.toList());
        return new Users(collect);
    }

    public int ladderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return Integer.parseInt(scanner.nextLine());
    }

    public void renderingLadder(List<String> userNames, Ladder ladder) {
        String collect = userNames.stream().collect(Collectors.joining(Preferences.userDelimiter()));

        renderingUserArea(collect);
        renderingLadderArea(ladder);
    }

    private void renderingLadderArea(Ladder ladder) {
        throw new RuntimeException("Not Yet Implemented");
    }

    private void renderingUserArea(String userNames) {
        System.out.println(userNames);

    }
}
