package ladder.domain;

public class Path {

    private int startIndex;
    private int endIndex;

    public Path(int startIndex, int endIndex){
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getEndIndex(){
        return endIndex;
    }
}
