package nextstep.ladder.domain;

import java.util.Objects;
import nextstep.ladder.exception.WrongLadderGamePrizeException;
import nextstep.ladder.util.StringUtils;

public class LadderGamePrize {

    private final String prizeName;

    public LadderGamePrize(String prizeName) {

        validatePrizeName(prizeName);

        this.prizeName = prizeName;
    }

    private void validatePrizeName(String prizeName) {
        if (StringUtils.isNullOrEmpty(prizeName)) {
            throw new WrongLadderGamePrizeException("게임결과보상 입력은 필수입니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LadderGamePrize that = (LadderGamePrize) o;
        return Objects.equals(prizeName, that.prizeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prizeName);
    }
}
