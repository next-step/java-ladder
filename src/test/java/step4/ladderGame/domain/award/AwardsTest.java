package step4.ladderGame.domain.award;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@SuppressWarnings("NonAsciiCharacters")
class AwardsTest {

    @DisplayName("생성")
    @Test
    void create() {
        assertThat(new Awards("qwe,asd,zxc,sdf", 4)).isInstanceOf(Awards.class);
    }

    @DisplayName("참가자와 결과의 갯수가 다를 경우 에러발생")
    @Test
    void validate_참가자와_결과의_갯수가_다를_경우_에러발생() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Awards("qwe,asd,zxc", 4);
        }).withMessageMatching("참가자와 결과의 갯수는 같아야합니다.");
    }

    @DisplayName("해당 인덱스의 결과를 조회")
    @ParameterizedTest
    @CsvSource(value = {"fail:0", "2000:1", "fail:2", "3000:3"}, delimiter = ':')
    void findIndex(String name, int index) {
        Awards awards = new Awards("fail,2000,fail,3000", 4);
        assertThat(awards.findResult(index)).isEqualTo(name);
    }

}
