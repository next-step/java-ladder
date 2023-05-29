package ladder.domain;

import java.util.List;
import java.util.Map;
import ladder.view.delegator.AllPrintResultDelegator;
import ladder.view.delegator.PrintResultDelegator;
import ladder.view.delegator.PrintType;
import ladder.view.delegator.SinglePrintResultDelegator;

public class PrintDelegator {

    private static final String PRINT_DELEGATOR_NOT_DEFINED = "출력형태가 정의되지 않았습니다.";

    private final PrintType type;

    private final Map<Participant, LadderResult> resultMap;

    private final List<PrintResultDelegator> delegators;

    public PrintDelegator(PrintType type, Map<Participant, LadderResult> resultMap) {
        this.type = type;
        this.resultMap = resultMap;
        this.delegators = List.of(new SinglePrintResultDelegator(), new AllPrintResultDelegator());
    }

    public void gerResultPrint() {
        findDelegator().generatePrint(resultMap);
    }

    public PrintResultDelegator getDelegator() {
        return findDelegator();
    }

    private PrintResultDelegator findDelegator() {
        return delegators.stream()
                .filter(delegator -> delegator.type() == this.type)
                .findFirst().orElseThrow(() -> new IllegalArgumentException(PRINT_DELEGATOR_NOT_DEFINED));
    }
}

