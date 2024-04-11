package nextstep.ladder.view;

import java.util.stream.Collectors;
import nextstep.ladder.domain.LadderResult;

public class ResultView {

  public void print(String result) {
    System.out.println(result);
  }

  public void printLadder(LadderResult ladder) {
    System.out.println(ladder.getPeopleNames().stream().map(name -> String.format("%-5s", name)).collect(Collectors.joining(" ")));
    ladder.getLadderResults().forEach(System.out::println);
  }
}
