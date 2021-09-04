package newladder.model;


import java.util.ArrayList;
import java.util.List;

public class Prize {
    private final List<String> prizes = new ArrayList<>();

    public Prize(String[] prizeList) {
        for (String prize : prizeList) {
            this.prizes.add(prize);
        }
    }

    public List<String> prizeInfo() {
        return this.prizes;
    }

    public String prizeInfo(int index) {
        return this.prizes.get(index);
    }
}
