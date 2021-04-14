package step4.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import step4.exception.NotEqualCountException;
import step4.exception.NotFoundException;
import step4.util.StringSpliter;

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

    public Prize matchPosition(Position position) {
        return prizes.stream()
            .filter(prize -> position.equals(prize.getPosition()))
            .findFirst()
            .orElseThrow(() -> new NotFoundException("유효하지 않은 상품번호 입니다."));
    }
}
