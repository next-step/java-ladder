package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PeopleTest {
    private People people;

    @BeforeEach
    void create() {
        List<String> nameList = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));
        people = new People(nameList);
    }

    @Test
    @DisplayName("입력한 사람 수만큼 count하는지 확인")
    void 사람수_확인() {
        assertThat(people.count()).isEqualTo(4);
    }

    @Test
    @DisplayName("사람 수에 맞게 사다리 좌표 수 구하기")
    void 사다리_좌표갯수_확인() {

        assertThat(people.ofCoordinateCount()).isEqualTo(3);
    }
}
