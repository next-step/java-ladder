package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Result를 여러 개 생성하는 유틸을 제공하는 유틸 클래스
 */
public class Results {
    private Results(){
    }

    /**
     * 쉼표로 구분되는 실행결과 문자열을 주면 분리하여 실행 결과 리스트로 만듭니다.
     *
     * @param results 쉼표로 구분되는 실행결과 문자열
     *
     * @return 분리된 실행 결과
     */
    public static List<ResultItem> of(String results) {
        String[] split = results.split(",");

        return Arrays.stream(split)
                .map(ResultItem::new)
                .collect(Collectors.toList());
    }
}
