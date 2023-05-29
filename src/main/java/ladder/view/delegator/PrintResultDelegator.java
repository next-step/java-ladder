package ladder.view.delegator;

import java.util.Map;
import ladder.domain.Participant;
import ladder.domain.LadderResult;

public interface PrintResultDelegator {

    PrintType type();

    void generatePrint(Map<Participant, LadderResult> resultMap);
}
