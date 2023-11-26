package nextstep.step4.responsibility.domain;

import java.util.Map;

public class LadderResult implements GameResultProvider {
    private final Map<String, String> result;

    public LadderResult(Map<String, String> result) {
        this.result = result;
    }

    @Override
    public String getResult(final String name) {
        return this.result.getOrDefault(name, null);
    }

    @Override
    public Map<String, String> getAllResult() {
        return this.result;
    }
}
