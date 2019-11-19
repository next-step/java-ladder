package ladder.domain;

public class Result {
    int index;
    String result;

    public Result(int index, String result) {
        this.index = index;
        this.result = result;
    }

    public int getIndex() {
        return index;
    }

    public String getResult() {
        return result;
    }
}
