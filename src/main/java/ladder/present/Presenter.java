package ladder.present;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import ladder.domain.Scene;
import ladder.domain.User;
import ladder.domain.Users;

public class Presenter {

  private final Scanner scanner;

  public Presenter() {
    this.scanner = new Scanner(System.in);
  }

  public Users users() {
    System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    return new Users(
        Arrays.stream(
                scanner.nextLine()
                    .split(",")
            )
            .map(User::new)
            .collect(Collectors.toList())
    );
  }

  public int ladderHeight() {
    System.out.println("최대 사다리 높이는 몇 개인가요?");
    return Integer.parseInt(scanner.nextLine());
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
