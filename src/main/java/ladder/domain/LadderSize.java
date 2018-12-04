package ladder.domain;

public class LadderSize {

    private LadderHeight height;
    private LadderWidth width;

    private LadderSize(int height, int width) {
        this.height = LadderHeight.from(height);
        this.width = LadderWidth.from(width);
    }

    public static LadderSize from(int height, int width) {
        return new LadderSize(height, width);
    }

    public int heightSize(){
       return height.size();
    }

    public int wightSize(){
        return width.size();
    }
}
