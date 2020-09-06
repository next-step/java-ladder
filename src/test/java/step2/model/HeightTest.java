package step2.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class HeightTest {
    Height height;

    @ParameterizedTest
    @CsvSource(value = {"5,5", "3,3", "123,123"})
    void create_Height_Class_and_Test(int initializer, int expected) {
        height = new Height(initializer);
        assertThat(height.getHeight()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {" -5, -12"})
    void create_Height_For_Testing_IllegalArgumentException_By_Negative_Number(int value) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Height(value))
        ;
    }
}
