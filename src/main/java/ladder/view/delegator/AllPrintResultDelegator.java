package ladder.view.delegator;

import java.util.Map;
import ladder.domain.Participant;
import ladder.domain.LadderResult;

public class AllPrintResultDelegator implements PrintResultDelegator {

    @Override
    public PrintType type() {
        return PrintType.ALL;
    }

    @Override
    public void generatePrint(Map<Participant, LadderResult> resultMap) {
        resultMap.forEach(
                ((participant, result) -> System.out.println(String.join(" : ", participant.getName(), result.getResult()))));
    }
}
