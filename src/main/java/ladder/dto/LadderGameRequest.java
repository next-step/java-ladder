package ladder.dto;

public class LadderGameRequest {

    private String[] nameList;

    private int height;

    private String[] prizeList;

    public LadderGameRequest(String[] nameList, String[] prizeList, int height) {
        this.nameList = nameList;
        this.prizeList = prizeList;
        this.height = height;
    }

    public String[] nameList() {
        return nameList;
    }

    public int height() {
        return height;
    }

    public String[] prizeList() {
        return prizeList;
    }
}
