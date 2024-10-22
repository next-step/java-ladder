package ladder.domain;

import java.util.Collections;
import java.util.List;

public class Rewords {
    private final List<Reword> rewords;

    public Rewords(List<Reword> rewords) {
        this.rewords = rewords;
    }

    public int getSize() {
        return rewords.size();
    }

    public List<Reword> getRewords() {
        return Collections.unmodifiableList(rewords);
    }

    public Reword get(int index) {
        if (index < 0 || index >= rewords.size()) {
            throw new IllegalArgumentException("객체 범위 외의 인덱스는 허용하지 않습니다.");
        }
        return rewords.get(index);
    }
}
