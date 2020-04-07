package JavaLadder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prizes prizes1 = (Prizes) o;
        return Objects.equals(prizes, prizes1.prizes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prizes);
    }
}
