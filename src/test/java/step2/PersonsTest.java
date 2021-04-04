package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonsTest {

    @Test
    @DisplayName("입력 받은 이름들을 리스트 반환 테스트")
    void inputNamesToList() {
       String inputNames = "pobi,crong,linux";
       assertThat(Persons.createPersons(inputNames).size()).isEqualTo(3);
    }
}
