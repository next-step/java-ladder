package ladder.view.dto;


import java.util.List;

public class LadderDTO {
    private final List<String> userNames;
    private final List<String> prizeNames;
    private final int height;

    public LadderDTO(List<String> userNames, List<String> prizeNames, int height) {
        this.userNames = userNames;
        this.prizeNames = prizeNames;
        this.height = height;
    }

    public List<String> getUserNames() {
        return userNames;
    }

    public List<String> getPrizeNames() {
        return prizeNames;
    }

    public int getHeight() {
        return height;
    }

}
