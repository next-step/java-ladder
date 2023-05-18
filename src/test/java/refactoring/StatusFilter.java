package refactoring;

import static refactoring.LineStatus.CONNECTION;
import static refactoring.LineStatus.DETACHMENT;

public class StatusFilter {

    private LineStatus previousStatus;

    private StatusFilter(final LineStatus currentStatus) {
        this.previousStatus = currentStatus;
    }

    public static LineStatus filter(LineStatus currentStatus) {
        var statusFilter = new StatusFilter(currentStatus);
        if (isDuplicate(currentStatus, statusFilter)) {
            statusFilter.changeStatus(DETACHMENT);
            return DETACHMENT;
        }
        return currentStatus;
    }

    private static boolean isDuplicate(final LineStatus currentStatus,
        final StatusFilter statusFilter) {
        return statusFilter.getPreviousStatus() == CONNECTION && currentStatus == CONNECTION;
    }

    private void changeStatus(final LineStatus lineStatus) {
        this.previousStatus = lineStatus;
    }

    public LineStatus getPreviousStatus() {
        return previousStatus;
    }
}
