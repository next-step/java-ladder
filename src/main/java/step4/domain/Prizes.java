package step4.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

import step4.exception.NotEqualCountException;
import step4.exception.NotFoundException;
import step4.util.StringSpliter;

public class Prizes {
    private final List<Prize> prizes = new ArrayList<>();

    private Prizes(String[] splitPrizes, int countOfPerson) {
        validate(splitPrizes.length, countOfPerson);
        IntStream.range(0, splitPrizes.length)
            .forEach(i -> prizes.add(new Prize(i, splitPrizes[i])));
    }

    public static Prizes of(String stringPrizes, int countOfPerson) {
        String[] splitPrizes = StringSpliter.split(stringPrizes);
        return new Prizes(splitPrizes, countOfPerson);
    }

    public static Prizes of(String[] splitPrizes, int countOfPerson) {
        return new Prizes(splitPrizes, countOfPerson);
    }

    private void validate(int size, int countOfPerson) {
        if (size != countOfPerson) {
            throw new NotEqualCountException("플레이어 수와 상품 수가 같아야 합니다.");
        }
    }

    public List<Prize> prizes() {
        return Collections.unmodifiableList(this.prizes);
    }

    public Prize matchPosition(Position position) {
        return prizes.stream()
            .filter(prize -> position.equals(prize.position()))
            .findFirst()
            .orElseThrow(() -> new NotFoundException("유효하지 않은 상품번호 입니다."));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Prizes prizes1 = (Prizes)o;
        return Objects.equals(prizes, prizes1.prizes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prizes);
    }
}
