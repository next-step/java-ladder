package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class PositiveNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -5, -10})
    void invalidNumber(final int invalidNumber) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new PositiveNumber(invalidNumber));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10})
    void validNumber(final int validNumber) {
        assertThat(new PositiveNumber(validNumber)).isEqualTo(new PositiveNumber(validNumber));
        assertThat(new PositiveNumber(validNumber)).isNotSameAs(new PositiveNumber(validNumber));
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2:3", "2:1:3", "5:10:15", "10:5:15"}, delimiter = ':')
    void plus(final int number1, final int number2, final int expected) {
        final PositiveNumber positiveNumber1 = new PositiveNumber(number1);

        assertThat(positiveNumber1.plus(new PositiveNumber(number2)))
            .isEqualTo(new PositiveNumber(expected));

        // assert that PositiveNumber object is immutable even after add operation
        assertThat(positiveNumber1).isEqualTo(new PositiveNumber(number1));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 5, 10})
    void isGreaterThan_sameValue(final int value) {
        assertThat(new PositiveNumber(value).isGreaterThan(new PositiveNumber(value)))
            .isFalse();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2", "5:10"}, delimiter = ':')
    void isGreaterThan(final int smallerValue, final int value) {
        assertThat(new PositiveNumber(value).isGreaterThan(new PositiveNumber(smallerValue)))
            .isTrue();
        assertThat(new PositiveNumber(smallerValue).isGreaterThan(new PositiveNumber(value)))
            .isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 5, 10})
    void isLessThanOrEquals_sameValue(final int value) {
        assertThat(new PositiveNumber(value).isLessThanOrEquals(new PositiveNumber(value)))
            .isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2", "5:10"}, delimiter = ':')
    void isLessThanOrEquals(final int smallerValue, final int value) {
        assertThat(new PositiveNumber(smallerValue).isLessThanOrEquals(new PositiveNumber(value)))
            .isTrue();
        assertThat(new PositiveNumber(value).isLessThanOrEquals(new PositiveNumber(smallerValue)))
            .isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 5, 10})
    void isLessThan_sameValue(final int value) {
        assertThat(new PositiveNumber(value).isLessThan(new PositiveNumber(value)))
            .isFalse();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2", "5:10"}, delimiter = ':')
    void isLessThan(final int smallerValue, final int value) {
        assertThat(new PositiveNumber(smallerValue).isLessThan(new PositiveNumber(value)))
            .isTrue();
        assertThat(new PositiveNumber(value).isLessThan(new PositiveNumber(smallerValue)))
            .isFalse();
    }

}