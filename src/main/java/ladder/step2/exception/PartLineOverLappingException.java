package ladder.step2.exception;

public class PartLineOverLappingException extends IllegalArgumentException {
    private static final String PARTlINE_OVER_LAPPING_EXCEPTION_MESAGE = "부분 라인은 겹칠 수 없습니다.";
    
    public PartLineOverLappingException() {
        super(PARTlINE_OVER_LAPPING_EXCEPTION_MESAGE);
    }
}
