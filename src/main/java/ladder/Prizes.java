package ladder;

import java.util.Arrays;
import java.util.List;

public class Prizes {
    private List<String> prizes;

    private Prizes(List<String> customPrize) {
        this.prizes = customPrize;
    }

    public static Prizes createPrizes(String input) {
        return new Prizes(Arrays.asList(input.split(",")));
    }

    public String get(int point) {
        return prizes.get(point);
    }

    public List<String> getPrizes() {
        return prizes;
    }

    public int size() {
        return prizes.size();
    }

    @Override
        public String toString () {
            StringBuilder stringBuilder = new StringBuilder();
            prizes.forEach(s -> stringBuilder.append("     ").append(s));
            return stringBuilder.toString();
        }

}
