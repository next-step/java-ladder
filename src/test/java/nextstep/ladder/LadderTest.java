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
        var strategy = new AlwaysGenerateStrategy();

        var ladder = new Ladder(users, levels, strategy);

        assertThat(ladder.height).isEqualTo(levels);
        assertThat(ladder.users).containsExactly("erik", "jake", "david");
    }

    @Test
    public void throwErrorOnNegativeInputs() {
        assertThatThrownBy(() -> {
            var levels = new Natural(-1);
            var users = new Users(List.of());
            var strategy = new AlwaysGenerateStrategy();
            new Ladder(users, levels, strategy);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Negative value given for natural number");
    }

    @Test
    public void legsAreNotPlacedConsecutively() {
        var height = new Natural(5);
        var users = new Users(List.of("erik", "jake", "david"));
        var strategy = new AlwaysGenerateStrategy();

        var ladder = new Ladder(users, height, strategy);

        for (int level = 0; level < height.value(); level++) {
            assertThatLegsAreNotPlacedConsecutivelyInLevel(ladder, level, users.size().value());
        }
    }

    private static void assertThatLegsAreNotPlacedConsecutivelyInLevel(Ladder ladder, long level, long width) {
        for (int place = 1; place < width; place++) {
            var previousLeg = ladder.legs.hasLegOnRightSide(new Position(level, place - 1));
            var currentLeg = ladder.legs.hasLegOnRightSide(new Position(level, place));
            assert !(previousLeg && currentLeg);
        }
    }
}
