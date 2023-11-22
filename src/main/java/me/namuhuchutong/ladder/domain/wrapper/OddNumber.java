package me.namuhuchutong.ladder.domain.wrapper;

import java.util.Objects;

public class OddNumber {

    private final int odd;

    public OddNumber(int number) {
        validateOdd(number);
        this.odd = number;
    }

    private void validateOdd(int number) {
        if (isNotOdd(number)) {
            throw new IllegalArgumentException("짝수는 입력할 수 없습니다.");
        }
    }

    private static boolean isNotOdd(int number) {
        return number % 2 == 0 || number < 0;
    }

    public int getOdd() {
        return this.odd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OddNumber oddNumber = (OddNumber) o;
        return odd == oddNumber.odd;
    }

    @Override
    public int hashCode() {
        return Objects.hash(odd);
    }
}
