package ladder.domain.reward;

import ladder.util.StringUtil;

public class Reward {
    private String name;

    private Reward(String name) {
        checkEmpty(name);
        this.name = name;
    }

    public static Reward of(String name) {
        return new Reward(name);
    }

    public String getName() {
        return name;
    }

    private void checkEmpty(String name) {
        if (StringUtil.isEmpty(name)) {
            throw new IllegalArgumentException("당첨 결과 이름이 없습니다.");
        }
    }
}
