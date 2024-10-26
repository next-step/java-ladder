package ladder;

import java.util.List;

public class Bettings {
    private static final int ZERO = 0;
    private final List<String> bettings;

    public Bettings(List<String> bettings) {
        this.bettings = bettings;
    }


    public String getBetting(int index) {
        if (index < ZERO || index >= bettings.size()) {
            throw new IllegalArgumentException("실행 결과에서 값을 찾을 수 없습니다.");
        }
        return bettings.get(index);
    }

    public int getBettingSize() {
        return this.bettings.size();
    }

    public List<String> getBettings() {
        return bettings;
    }
}
