package ladder.domain.ladder.line;

public interface ConnectionGenerator {

    Connection generateFirst();

    Connection generateNext(final Connection previousConnection);
}
