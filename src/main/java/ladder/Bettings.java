package ladder;

import ladder.name.Names;

import java.util.List;

public class Bettings {
    private static final int ZERO = 0;
    private final List<String> bettings;

    public Bettings(List<String> bettings, Names names) {
        if(names.hasDifferentSize(bettings.size())) {
            throw new IllegalArgumentException("참여자와 실행 결과의 수가 동일해야합니다.");
        }
        this.bettings = bettings;
    }

    public List<String> getBettings() {
        return bettings;
    }

    public String getBetting(int index) {
        if (index < ZERO || index >= bettings.size()) {
            throw new IllegalArgumentException("실행 결과에서 값을 찾을 수 없습니다.");
        }
        return bettings.get(index);
    }

}
