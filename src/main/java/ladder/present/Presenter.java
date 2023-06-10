package ladder.present;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import ladder.domain.Scene;
import ladder.domain.User;
import ladder.domain.Users;
import ladder.exception.OutOfLadderHeightException;
import ladder.exception.OutOfUsersCountException;

public class Presenter {

  private static final int MAX_ROW_AND_RADDER_HEIGHT = 50;
  private static final int MAX_COLUMN_AND_USER_COUNT = 50;
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
    if (usersCount > MAX_COLUMN_AND_USER_COUNT) {
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
    if (height > MAX_ROW_AND_RADDER_HEIGHT) {
      throw new OutOfLadderHeightException();
    }
  }

  public void renderingLadder(Scene scene) {
    renderingUserArea(scene.userArea());
    renderingLadderArea(scene);
  }

  private void renderingLadderArea(Scene scene) {
    scene.getLadderArea()
        .forEach(System.out::println);
  }

  private void renderingUserArea(String userNames) {
    System.out.println(userNames);
  }
}
