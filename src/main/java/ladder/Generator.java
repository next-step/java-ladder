package ladder;

/**
 * 특정 타입의 인스턴스를 생성하는 로직 객체가 구현해야 하는 인터페이스입니다.
 * @param <T> 이 생성 로직이 최종적으로 생성하는 객체의 타입
 */
public interface Generator<T> {

    /**
     * 이 로직 객체가 정의한 전략에 따라 객체를 생성해 반환합니다.
     *
     * @return 생성된 객체
     */
    public T make();
}
