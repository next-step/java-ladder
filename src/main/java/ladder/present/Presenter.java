package ladder.present;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import ladder.domain.Ladder;
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
    log.info("\n참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
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
    log.info("\n최대 사다리 높이는 몇 개인가요?");
    return Integer.parseInt(scanner.nextLine());
  }

  public void renderingLadder(Scene scene) {
    renderingHeader(scene.userArea());
    renderingLadderBody(scene);
    renderingFooter(scene.prizeArea());
  }

  private void renderingLadderBody(Scene scene) {
    scene.getLadderArea()
        .forEach(log::info);
  }

  private void renderingHeader(String userNames) {
    log.info(userNames);
  }

  public Results results(Users users, Ladder ladder) {
    log.info("\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
    return new Results(
        Arrays.stream(scanner.nextLine().split(","))
            .collect(Collectors.toList()),
        users.getUsers(),
        ladder
    );
  }

  public void renderingFooter(String string) {
    log.info(string);
  }

  public void renderingResults(Scene scene, Results results) {
    log.info("\n결과를 보고 싶은 사람은?");
    String command = scanner.nextLine();
    log.info("{}", command);
    log.info("\n실행결과");
    results.findAllPrizesByUserOrAll(command).forEach(log::info);
  }
}
