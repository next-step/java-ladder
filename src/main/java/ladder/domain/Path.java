package ladder.domain;

public class Path {

    private int startIndex;
    private int endIndex;

    private Path(int startIndex, int endIndex){
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    public static Path of(int startIndex, int endIndex){
        return new Path(startIndex, endIndex);
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getEndIndex(){
        return endIndex;
    }
}
