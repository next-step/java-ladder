package nextstep.ladder.domain.ladder;

/**
 * 발판 생성 규칙
 */
@FunctionalInterface
public interface RungGenerateStrategy {

    boolean addable();

}
