package ladder.present;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import ladder.domain.Results;
import ladder.domain.Scene;
import ladder.domain.User;
import ladder.domain.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Presenter {

  private static final Logger log = LoggerFactory.getLogger(Presenter.class);
  private final Scanner scanner;

  public Presenter() {
    this.scanner = new Scanner(System.in);
  }

  public Users users() {
    log.info("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
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
    log.info("최대 사다리 높이는 몇 개인가요?");
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

  public Results results() {
    log.info("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
    return new Results(
        Arrays.stream(
            scanner.nextLine()
                .split(",")
        ).collect(Collectors.toList())
    );
  }
}
