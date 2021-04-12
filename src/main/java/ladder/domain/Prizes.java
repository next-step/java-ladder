package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import ladder.exception.NotEqualCountException;
import ladder.exception.NotFoundException;
import ladder.utils.StringSpliter;

public class Prizes {
    private final List<Prize> prizes = new ArrayList<>();

    public Prizes(String stringPrizes, int countOfPerson) {
        String[] splitPrizes = StringSpliter.split(stringPrizes);
        validate(splitPrizes.length, countOfPerson);
        IntStream.range(0, splitPrizes.length)
            .forEach(i -> prizes.add(new Prize(i, splitPrizes[i])));
    }
    private void validate(int size, int countOfPerson) {
        if (size != countOfPerson) {
            throw new NotEqualCountException("플레이어 수와 상품 수가 같아야 합니다.");
        }
    }

    public List<Prize> getPrizes() {
        return Collections.unmodifiableList(this.prizes);
    }

    public Prize matchNumber(LineNumber number) {
        return prizes.stream().filter(prize -> number.equals(prize.getLineNumber()))
            .findFirst()
            .orElseThrow(() -> new NotFoundException("유효하지 않은 상품번호 입니다."));
    }
}
