package nextstep.ladder;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LadderTest {
    @Test
    public void levelAndUsersAreSet() {
        var levels = new Natural(5);
        var users = new Users(List.of("erik", "jake", "david"));

        var ladder = new Ladder(users, levels, () -> true);

        assertThat(ladder.height).isEqualTo(levels);
        assertThat(ladder.users).containsExactly("erik", "jake", "david");
    }

    @Test
    public void throwErrorOnNegativeInputs() {
        assertThatThrownBy(() -> {
            var levels = new Natural(-1);
            var users = new Users(List.of());
            new Ladder(users, levels, () -> true);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Negative value given for natural number");
    }

    @Test
    public void legsAreNotPlacedConsecutively() {
        var height = new Natural(5);
        var users = new Users(List.of("erik", "jake", "david"));

        var ladder = new Ladder(users, height, () -> true);

        for (int level = 0; level < height.value(); level++) {
            assertThatLegsAreNotPlacedConsecutivelyInLevel(ladder, level, users.size().value());
        }
    }

    private static void assertThatLegsAreNotPlacedConsecutivelyInLevel(Ladder ladder, long level, long width) {
        for (int place = 1; place < width; place++) {
            var currentPosition = new Position(level, place);
            var currentLeg = ladder.legs.hasLegOnRightSideOf(currentPosition);
            var leftLeg = ladder.legs.hasLegOnRightSideOf(currentPosition.getLeftPosition());
            assert !(leftLeg && currentLeg);
        }
    }
}
