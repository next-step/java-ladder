package ladder.domain;

public class LadderSize {

    private LadderHeight ladderHeight;
    private PersonSize personSize;

    private LadderSize(int height, int size) {
        this.ladderHeight = LadderHeight.from(height);
        this.personSize = PersonSize.from(size);
    }

    public static LadderSize from(int height, int width) {
        return new LadderSize(height, width);
    }

    public static LadderSize from(Difficulty difficulty, int width) {
        return new LadderSize(difficulty.height(), width);
    }

    public int heightSize(){
       return ladderHeight.size();
    }

    public int wightSize(){
        return personSize.size();
    }
}
