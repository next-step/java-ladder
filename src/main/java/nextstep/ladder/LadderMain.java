package nextstep.ladder;

import nextstep.ladder.service.LadderGame;

import java.util.Scanner;

public class LadderMain {
  public static void main(String[] args) {
    LadderGame game = new LadderGame(new Scanner(System.in));
    game.run();
  }
}
