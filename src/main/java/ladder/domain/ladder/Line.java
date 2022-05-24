package ladder.domain.ladder;

import ladder.exception.OverlapLineException;

import java.util.*;
import java.util.stream.IntStream;

public class Line {
    private static final Random random = new Random();
    private List<Boolean> contentList;

    public Line(int countOfPerson) {
        this(createContent(countOfPerson - 1));
    }

    public Line(List<Boolean> contents) {
        validate(contents);
        this.contentList = contents;
    }

    private void validate(List<Boolean> contents) {
        IntStream.range(0, contents.size() - 1).filter(i -> contents.get(i) == true && contents.get(i + 1) == true).forEach(i -> {
            throw new OverlapLineException("Line이 겹치는 부분이 있습니다.");
        });
    }

    private static List<Boolean> createContent(int person){
        List<Boolean> tmpContentList = new ArrayList<>();

        IntStream.range(0, person).forEach(i -> {
            if (tmpContentList.isEmpty()) {
                tmpContentList.add(randomBoolean());
                return;
            }

            Boolean prevLine = tmpContentList.get(tmpContentList.size() - 1);
            if (!prevLine) {
                tmpContentList.add(randomBoolean());
                return;
            }
            tmpContentList.add(false);
        });

        return tmpContentList ;
    }

    private static boolean randomBoolean() {
        return random.nextBoolean();
    }

    public List<Boolean> getContents() {
        return contentList;
    }
}
