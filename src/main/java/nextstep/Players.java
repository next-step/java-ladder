package nextstep;

import java.util.ArrayList;
import java.util.List;

public class Players {
    private final List<String> names;

    public Players(String[] names) {
        this.names = new ArrayList<>();
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("사람의 이름은 최대5글자까지 부여할 수 있습니다 : " + name);
            }
            this.names.add(name);
        }
    }

    public String names() {
        return names.toString();
    }
}
