package nextstep.ladder.domain;



public class LadderGame {
    private Ladder ladder;
    private Players players;


    public LadderGame(Ladder ladder ,Players players) {
        this.ladder = ladder;
        this.players = players;
    }

    public void execute() {

    }

    public int start(int index) {
        if (index ==-1){

        }
        return ladder.search(index);
    }
}
