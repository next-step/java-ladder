package ladder;

import ladder.domain.Aisle;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AisleTest {
    @Test
    public void printAisle() {
        //given
        Aisle existAisle = new Aisle(true);
        Aisle nonExistAisle = new Aisle(false);
        String expectExistAisle = "-------";
        String expectNonExistAisle = "       ";

        //when
        String resultExistAisle = existAisle.printAisle();
        String resultNonExistAisle = nonExistAisle.printAisle();

        //then
        assertThat(resultExistAisle).isEqualTo(expectExistAisle);
        assertThat(resultNonExistAisle).isEqualTo(expectNonExistAisle);
    }
}
