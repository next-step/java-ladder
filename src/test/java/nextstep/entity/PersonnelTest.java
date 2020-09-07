package nextstep.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.BDDAssertions.then;

class PersonnelTest {

    @ParameterizedTest
    @DisplayName("참가자 수 확인")
    @CsvSource(value = {"0,0", "1,1", "2,2"})
    void getPersonnel(int personnel, int expected) {
        then(Personnel.of(personnel).getPersonnel()).isEqualTo(expected);
    }
}
