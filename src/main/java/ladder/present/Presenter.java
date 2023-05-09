package ladder.present;

import ladder.control.Preferences;
import ladder.domain.Renderer;
import ladder.domain.User;
import ladder.domain.Users;
import ladder.exception.OutOfLadderHeightException;
import ladder.exception.OutOfUsersCountException;

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
        String[] inputUsers = s.split(",");
        validateInputUsersCount(inputUsers.length);
        return new Users(
                Arrays.stream(inputUsers)
                        .map(User::new)
                        .collect(Collectors.toList())
        );
    }

    private void validateInputUsersCount(int usersCount) {
        if(usersCount > Preferences.maxUserCount()) {
            throw new OutOfUsersCountException();
        }
    }

    public int ladderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = Integer.parseInt(scanner.nextLine());
        validateInputLadderHeight(height);
        return height;
    }

    private void validateInputLadderHeight(int height) {
        if(height > Preferences.maxLadderHeight()) {
            throw new OutOfLadderHeightException();
        }
    }

    public void renderingLadder(List<String> userNames, Renderer ladderRender) {
        String collect = userNames.stream().collect(Collectors.joining(Preferences.userDelimiter()));

        renderingUserArea(collect);
        renderingLadderArea(ladderRender);
    }

    private void renderingLadderArea(Renderer ladderRender) {
        List<String> randering = ladderRender.rendering();
        randering.stream().forEach(s -> System.out.println(s));
    }

    private void renderingUserArea(String userNames) {
        System.out.println(userNames);

    }
}
