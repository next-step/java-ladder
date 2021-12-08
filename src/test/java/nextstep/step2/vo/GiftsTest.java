package nextstep.step2.vo;

import nextstep.step2.domain.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class GiftsTest {

    @DisplayName("List<Gift> 의 크기가 2 보다 작을 경우 illegal exception")
    @Test
    void lessThanOneTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> Gifts.from(
                Arrays.asList(Gift.from("test"))
        ));
    }

    @DisplayName("Null or Empty input illegal exception")
    @ParameterizedTest
    @NullAndEmptySource
    void nullOrEmptyTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> Gifts.fromWithString(input));
    }

    @DisplayName("size() 메서드는 Gift의 갯수를 구한다.")
    @ParameterizedTest
    @CsvSource(value = {"abc,dasd,sadas,d:4", "abc,ddd:2"}, delimiter = ':')
    void sizeTest(String input, int expect) {
        Gifts gifts = Gifts.fromWithString(input);

        assertThat(gifts.size()).isEqualTo(expect);
    }

    @DisplayName("정상 생성 테스트")
    @Test
    void createTest() {
        assertThat(Gifts.from(Arrays.asList(Gift.from("miz"), Gift.from("mi"))))
                .isEqualTo(Gifts.from(Arrays.asList(Gift.from("miz"), Gift.from("mi"))));
    }

    @DisplayName("정상 ','로 구분 된 String 도 생성 할 수 있다.")
    @Test
    void createWithStringTest() {
        assertThat(Gifts.fromWithString("miz,mi"))
                .isEqualTo(Gifts.from(Arrays.asList(Gift.from("miz"), Gift.from("mi"))));
    }


    @DisplayName("equalsSize() 메서드는 갯수가 같은지 판별한다.")
    @ParameterizedTest
    @CsvSource(value = {"abc,dasd,sadas,d:4:true", "abc,ddd:3:false"}, delimiter = ':')
    void sizeTest(String input, int size, boolean expect) {
        Gifts gifts = Gifts.fromWithString(input);

        assertThat(gifts.equalsSize(size)).isEqualTo(expect);
    }

    @DisplayName("getGift()는 특정 순서의 gift를 반환한다.")
    @Test
    void getGiftTest() {
        Gifts gifts = Gifts.fromWithString("1000,2000");
        assertThat(gifts.giftWithIndex(Point.from(0))).isEqualTo(Gift.from("1000"));
        assertThat(gifts.giftWithIndex(Point.from(1))).isEqualTo(Gift.from("2000"));
    }

    @DisplayName("getGift()는 index가 범위에 맞지 않으면 illegal exception.")
    @Test
    void getGiftFailTest() {
        Gifts gifts = Gifts.fromWithString("1000,2000");
        assertThatIllegalArgumentException().isThrownBy(() -> gifts.giftWithIndex(Point.from(3)));
        assertThatIllegalArgumentException().isThrownBy(() -> gifts.giftWithIndex(Point.from(-1)));
    }
}
