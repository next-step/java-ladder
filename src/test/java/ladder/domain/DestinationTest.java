package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DestinationTest {

    @Test
    @DisplayName("실행 결과 생성 테스트")
    void destinationTest(){
        final Destination destination = new Destination("none");

        assertThat(destination.result()).isEqualTo("none");
    }

    @Test
    @DisplayName("실행 결과 여러개 생성 테스트")
    void destinationsTest(){
        final Destination destinationA = new Destination("none");
        final Destination destinationB = new Destination("5000");

        Destinations destinations = new Destinations(List.of(destinationA, destinationB));

        assertThat(destinations.destinations()).hasSize(2);
        assertThat(destinations.destinations()).contains(destinationA, destinationB);
        assertThat(destinations.count()).isEqualTo(2);
    }
}
