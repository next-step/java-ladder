package nextstep.ladder.domain;

import java.util.List;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-ladder
 * create date  : 2019-06-29 02:15
 */
public class Custom {
    private List<String> names;

    public Custom(List<String> names) {
        this.names = names;
    }

    public boolean hasCustom(String name) {
        return names.stream()
                .filter(sourceName -> name.equals(sourceName))
                .findFirst()
                .isPresent();
    }
}
