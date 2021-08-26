package ladder.model;


import java.util.ArrayList;
import java.util.List;

public class Prize {
    private final List<String> prizeList = new ArrayList<>();

    public Prize(String[] prizeList) {
        for (String prize : prizeList) {
            this.prizeList.add(prize);
        }
    }

    public List<String> prizeInfo() {
        return this.prizeList;
    }

    public String prizeInfo(int index) {
        return this.prizeList.get(index);
    }
}
