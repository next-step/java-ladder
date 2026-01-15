package nextstep.ladder.view;

import java.util.List;
import nextstep.ladder.LadderGameResult;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.domain.Rewards;

public class OutputView {

  public static void printLadderStatus(Participants participants, Ladder ladder, Rewards rewards) {
    printHeader();
    printLadderStatus(participants, ladder);
    printRewards(rewards);
  }

  public static void printLadderStatus(Participants participants, Ladder ladder) {
    printParticipants(participants);
    printLadder(ladder);
  }

  private static void printHeader() {
    System.out.println("\n사다리 결과\n");
  }

  private static void printParticipants(Participants participants) {
    System.out.println(formatNames(participants.getNames()));
  }

  private static void printLadder(Ladder ladder) {
    System.out.print(ladder);
  }

  private static void printRewards(Rewards rewards) {
    System.out.println(formatNames(rewards.getRewards()));
  }

  private static String formatNames(List<String> names) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < names.size(); i++) {
      if (i != 0) {
        sb.append(" ");
      }
      sb.append(String.format("%5s", names.get(i)));
    }
    return sb.toString();
  }

  public static void printResult(String result) {
    System.out.println("\n실행 결과");
    System.out.println(result);
  }

  public static void printAllResults(LadderGameResult result) {
    System.out.println("\n실행 결과");
    result.getAllResults()
        .forEach((name, reward) -> System.out.println(name + " : " + reward));
  }

}
