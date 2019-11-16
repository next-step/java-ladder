package nextstep.ladder.domain;

public class LadderGame {

    public static Ladder newInstance(int size, int height) {
        return new Ladder(size, height);
    }
}
