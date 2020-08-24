package nextstep.ladder;

import java.util.List;
import java.util.Scanner;

public class LadderGame {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    ViewInput viewInput = new ViewInput(scanner);
    Players players = viewInput.ready();

    List<Horizon> ladder = LadderGenerator.generate(players);
    ViewOutput.render(players, ladder);
  }
}
