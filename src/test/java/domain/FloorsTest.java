package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FloorsTest {
    private static final List<Boolean> RANDOM_GENRERATED_FLOOR_STATES_ONE = Arrays.asList(true, false, true);
    private static final List<Boolean> RANDOM_GENRERATED_FLOOR_STATES_TWO = Arrays.asList(false, false, true);
    private static final int FLOOR_SIZE = 2;

    @Test
    @DisplayName("Test produceFloor function of Floors class")
    void testProduceFloor() {
        Floors floors = new Floors();
        floors.produceFloor(RANDOM_GENRERATED_FLOOR_STATES_ONE);
        floors.produceFloor(RANDOM_GENRERATED_FLOOR_STATES_TWO);
        assertThat(floors.size()).isEqualTo(FLOOR_SIZE);
        List<Floor> floorList = floors.stream().collect(Collectors.toList());
        assertThat(floorList.get(0).getStates()).isEqualTo(RANDOM_GENRERATED_FLOOR_STATES_ONE);
        assertThat(floorList.get(1).getStates()).isEqualTo(RANDOM_GENRERATED_FLOOR_STATES_TWO);
    }
}
