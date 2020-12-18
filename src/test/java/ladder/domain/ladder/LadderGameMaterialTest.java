package ladder.domain.ladder;

import ladder.domain.dto.LadderMaterial;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class LadderGameMaterialTest {

    @Test
    public void createInstanceTest() {
        //Given
        Ladder ladder = LadderFactory.makeLadder(new LadderStructure(3,4), new RandomLineGenerator());
        List<String> participantsName = Arrays.asList("test","test1","test2");

        //When
        LadderMaterial material = new LadderMaterial(participantsName, ladder);

        //Then
        assertThat(material.getParticipantNames()).containsAll(participantsName);
    }
}
