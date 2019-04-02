package ladder;


public class LadderGame {
    private final LadderGenerator ladderGenerator;
    private Ladder ladder;

    public LadderGame(LadderGenerator ladderGenerator) {
        this.ladderGenerator = ladderGenerator;
    }

    public void init(int countOfPerson, int height) {
        this.ladder = ladderGenerator.generate(countOfPerson, height);
    }


    public Ladder getLadder() {
        return ladder;
    }
}
