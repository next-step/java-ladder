package nextstep.ladder;

import nextstep.ladder.controller.LadderGame;

public final class MainApplication {

    public static void main(String[] args) {
        LadderGame.of(System.in, System.out).start();
    }
}
