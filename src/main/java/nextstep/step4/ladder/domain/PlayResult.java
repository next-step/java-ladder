package nextstep.step4.ladder.domain;

import java.util.Map;
import java.util.stream.Stream;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-ladder
 * create date  : 2019-07-03 17:58
 */
public class PlayResult {
    private final Map<Name, Prize> result;

    public PlayResult(Map<Name, Prize> result) {
        this.result = result;
    }

    public Prize findPrizeByName(Name sourceName) {
        Name source = result.keySet().stream()
                .filter(name -> name.equals(sourceName))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);

        return result.get(source);
    }

    public Stream<Name> keySet() {
        return result.keySet().stream();
    }
}
