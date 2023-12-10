package nextstep.ladder;

public class LadderGame {

    private Users user;

    public Ladder makeLadder(int height) {
        return new Ladder(height, user.size());
    }



}
