package ladder.domain.dto;

import ladder.domain.participant.Participant;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultTest {


    @ParameterizedTest
    @MethodSource("createParticipant")
    public void searchTest(List<Participant> participants, int index) {
        //Given
        List<String> rowReward = Arrays.asList("꽝","5000","5000");
        Rewards rewards = new Rewards(rowReward);
        GameResult gameResult = new GameResult(participants, rewards);

        //When
        String rewardResult = gameResult.search(participants.get(index).getUserName());

        //Then
        assertThat(rewardResult).isEqualTo(rowReward.get(index));
    }

    private static Stream<Arguments> createParticipant() {
        return  Stream.of(
                Arguments.of(Arrays.asList(new Participant("user",0),
                                           new Participant("user1",1),
                                           new Participant("user2", 2)), 0
                            )
        );
    }
}
