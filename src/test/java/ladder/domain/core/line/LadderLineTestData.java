package ladder.domain.core.line;

import java.util.List;

import org.assertj.core.util.Lists;

import ladder.domain.core.line.move.MovableLineTestData;
import ladder.domain.core.line.name.LadderResultLine;
import ladder.domain.core.line.name.ParticipantsLine;

public class LadderLineTestData {

   /*
      a     b     c
      |-----|     |
      |     |-----|
      |-----|     |
      1     2     3
   */

    public static List<Line> type01(){
        return Lists.list(
            ParticipantsLine.of("a,b,c"),
            MovableLineTestData.type01(),
            LadderResultLine.of("1,2,3")
        );
    }
}
