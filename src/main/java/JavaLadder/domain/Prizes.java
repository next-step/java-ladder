package JavaLadder.domain;

import java.util.ArrayList;
import java.util.List;

public class Prizes {
    private static final String REGEX = ",";
    private List<Prize> prizeList = new ArrayList<>();

    public Prizes(String inputValue) {
        String[] splitInputValue = inputValue.split(REGEX);
        for (int i = 0; i < splitInputValue.length; i++) {
            Prize prize = new Prize(splitInputValue[i]);
            this.prizeList.add(prize);
        }
    }

    public String getPrize(int index) {
        return prizeList.get(index).getPrize();
    }

    public String getPrize(Point point) {
        return prizeList.get(point.getPoint()).getPrize();
    }

    public int size() {
        return this.prizeList.size();
    }
}
