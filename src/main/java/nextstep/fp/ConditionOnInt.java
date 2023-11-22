package nextstep.fp;

/**
 * 정수에 대해 조건 판별을 하는 함수형 인터페이스입니다.
 */
@FunctionalInterface
public interface ConditionOnInt {

    /**
     * 주어진 정수 `testTarget`에 대해 조건 판별을 하고 그 결과를 반환합니다.
     * 정의된 조건이 만족되면 true를 반환합니다.
     *
     * @param testTarget 조건을 검사할 정수
     * @return 조건 만족 여부. 만족 시 true 반환
     */
    public boolean test(int testTarget);
}
