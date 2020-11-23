package ladder.domain;

import ladder.dto.ResultDto;
import ladder.exception.BadResultException;

import static ladder.asset.LadderConst.STANDARD_LENGTH;

/**
 * NOTE: Person 과 로직이 중복되어 보이지만, 의도적으로 중복시켰다.
 * 왜냐하면 Person 과 Result 는 개념상 전혀 다른 도메인이기 때문이다.
 */
public class Result {
    private final String result;

    public Result(String result) {
        if (result.length() > STANDARD_LENGTH) {
            throw BadResultException.getInstance();
        }
        this.result = result;
    }

    ResultDto exportResultDto() {
        return new ResultDto(result);
    }
}
