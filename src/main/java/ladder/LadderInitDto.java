package ladder;

import java.util.List;

public class LadderInitDto {

    private final List<String> names;
    private final List<String> rewardValues;
    private final int height;

    public LadderInitDto(List<String> names, List<String> rewardValues, int height) {
        this.names = names;
        this.rewardValues = rewardValues;
        this.height = height;
    }

    public List<String> getNames() {
        return names;
    }

    public List<String> getRewardValues() {
        return rewardValues;
    }

    public int getHeight() {
        return height;
    }

}
