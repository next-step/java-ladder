package ladder.dto;

public class LadderGameRequest {

    private String[] nameList;

    private int height;

    private String[] prizeList;

    public LadderGameRequest(String[] nameList, String[] prizeList, int height) {
        validateNameListAndPrizeListCount(nameList, prizeList);
        this.nameList = nameList;
        this.prizeList = prizeList;
        this.height = height;
    }

    private void validateNameListAndPrizeListCount(String[] nameList, String[] prizeList) {
        if (nameList.length != prizeList.length) {
            throw new IllegalArgumentException("이름과 결과의 갯수는 같아야 합니다.");
        }
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
