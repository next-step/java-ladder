package nextstep.step3.ladder.dto;

import nextstep.step3.ladder.domain.Name;
import nextstep.step3.ladder.domain.Prize;

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
public class Result {
    private Map<Name, Prize> resultDto;

    public Result(Map<Name, Prize> resultDto) {
        this.resultDto = resultDto;
    }

    public Prize getPrize(String name) {
        Name searchName = resultDto.keySet().stream()
                .filter(sourceName -> sourceName.isName(Name.of(name)))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("참여자가 아닙니다."));

        return resultDto.get(searchName);
    }

    public Stream<Name> keySet() {
        return resultDto.keySet().stream();
    }

    public Stream<Prize> values() {
        return resultDto.values().stream();
    }
}
