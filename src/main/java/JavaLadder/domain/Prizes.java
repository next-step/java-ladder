package JavaLadder.domain;

import java.util.ArrayList;
import java.util.List;

public class Prizes {
    private static final String REGEX =",";
    private List<Prize> prizes = new ArrayList<>();

    public Prizes(String input) {
        String[] splitInputValue = input.split(REGEX);
        for (int i = 0; i < splitInputValue.length; i++) {
            Prize prize = new Prize(splitInputValue[i]);
            this.prizes.add(prize);
        }
    }

    public String getPrize(int index) {
        return prizes.get(index).getPrize();
    }

    public int size() {
        return prizes.size();
    }
}
