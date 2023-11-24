package nextstep.step4.responsibility.domain;

import java.util.Map;

public class LadderResult implements GameResultProvider {
    private final Map<String, String> result;

    public LadderResult(Map<String, String> result) {
        this.result = result;
    }

    @Override
    public String getResult(final String name) {
        if ("all".equals(name)) {
            return buildAllResult();
        }

        return this.result.getOrDefault(name, "존재하지 않는 이름입니다.");
    }

    private String buildAllResult() {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, String> entry : this.result.entrySet()) {
            sb.append(String.format("%s : %s", entry.getKey(), entry.getValue()));
            sb.append("\n");
        }

        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }
}
