package nextstep.view;

import nextstep.domain.LadderGame;
import nextstep.domain.User;

public class ResultView {
    public static void printLadder(LadderGame ladderGame) {
        System.out.println("\n\n");
        System.out.println("실행결과");

        ladderGame.getUseGroup().stream()
                .map(User::getName)
                .forEach(name -> System.out.print(name + "     "));
    }
}
