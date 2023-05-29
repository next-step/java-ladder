package ladder.view.delegator;

import java.util.Map;
import ladder.domain.Participant;
import ladder.domain.LadderResult;

public class SinglePrintResultDelegator implements PrintResultDelegator {

    private static final String RESULT_NOT_EXIST = "결과가 존재하지 않습니다.";

    @Override
    public PrintType type() {
        return PrintType.SINGLE;
    }

    @Override
    public void generatePrint(Map<Participant, LadderResult> resultMap) {
        String result = resultMap.values().stream()
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(RESULT_NOT_EXIST))
                .getResult();

        System.out.println(result);
    }
}
