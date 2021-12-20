package ladder.domain.ladder;

import ladder.domain.user.Name;
import ladder.domain.user.Participants;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderContextTest {

    @Test
    void d() {
        Participants participants = new Participants("dugi, manse, tomas, jk, papap");
        int inputLadderHeight = 5;
        int inputNumberOfParticipant = participants.size();

        LadderContext ladderContext = new LadderContext(inputLadderHeight, inputNumberOfParticipant);

        int ladderHeight = ladderContext.ladderHeight();
        int lineSize = ladderContext.lineSize();

        assertThat(ladderHeight).isEqualTo(inputLadderHeight);
        assertThat(lineSize).isEqualTo(inputNumberOfParticipant);

        List<Name> names = participants.get();
        StringBuilder nameSb = new StringBuilder();
        for (Name name : names) {
            nameSb.append(name);
            int nameLength = 5 - name.toString().length();
            if (nameLength > 0) {
                for (int i = 0; i < nameLength; i++) {
                    nameSb.append(" ");
                }
            }
        }
        System.out.println(nameSb);

        for (int i = 0; i < ladderHeight; i++) { // 사다리 높이
            StringBuilder sb = new StringBuilder("|");
            for (int j = 0; j < lineSize - 1; j++) { // 라인 크기
                sb.append(getLine(ladderContext.isRight(i, j)));
            }
            System.out.println(sb);
        }
    }

    private String getLine(boolean is) {
        if (is) {
            return "-----|";
        }
        return "     |";
    }
}