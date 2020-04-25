package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonsTest {
    @Test
    @DisplayName("주어진 이름 갯수만큼의 사람 리스트 생성 테스트")
    public void generatePrersonsByName() {
        String[] names = new String[]{"test1", "test2", "test3", "test4"};
        Persons persons = Persons.getInstance(names);

        assertThat(persons.getCount()).isEqualTo(names.length);
    }
}
