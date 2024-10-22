package ladder;

import java.util.List;

public class Bettings {
    private static final int ZERO = 0;
    private final List<String> bettongs;

    public Bettings(List<String> bettongs) {
        this.bettongs = bettongs;
    }

    public List<String> getBettongs() {
        return bettongs;
    }

    public String getBetting(int index) {
        if (index < ZERO || index >= bettongs.size()) {
            throw new IllegalArgumentException("실행 결과에서 값을 찾을 수 없습니다.");
        }
        return bettongs.get(index);
    }

}
