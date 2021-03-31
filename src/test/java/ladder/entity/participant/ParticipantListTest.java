package ladder.entity.participant;

import ladder.Util;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

class ParticipantListTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "a,b,c,d,e",
            "aa,bb,cc,dd,ee",
            "aaa,bbb,ccc,ddd",
            "aaaa,bbbb,cccc",
            "aaaaa,bbbbb"})
    void canGenerateParticipantList(String input) {
        ParticipantList participantList = new ParticipantList(input);
        List<Participant> testParticipants = Util.participantList(input);
        SoftAssertions softAssertions = new SoftAssertions();
        for (int index = 0; index < participantList.size(); index++) {
            softAssertions.assertThat(participantList.get(index)).isEqualTo(testParticipants.get(index));
        }
        softAssertions.assertAll();
    }

}
