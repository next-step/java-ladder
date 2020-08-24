package camp.nextstep.edu.rebellion.domain.reward;

import camp.nextstep.edu.rebellion.util.StringUtil;

public class Reward {
    private String name;

    public Reward(String name) {
        checkEmpty(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void checkEmpty(String name) {
        if (StringUtil.isEmpty(name)) {
            throw new IllegalArgumentException("당첨결과 이름이 없습니다");
        }
    }
}
