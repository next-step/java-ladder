package ladder;

/**
 * 사다리에서 라인 하나를 생성하는 전략 클래스가 구현체가 구현해야 할 인터페이스입니다.
 */
public interface LadderLineGenerator {

    /**
     * 이 로직 객체가 정의한 전략에 따라 객체를 생성해 반환합니다.
     *
     * @return 생성된 객체
     */
    public LadderLine generate();
}
