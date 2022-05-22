package ladder.domain.ladder;

import java.util.*;
import java.util.stream.IntStream;

public class Line {
    private List<Boolean> contentList = new ArrayList<>();

    public Line(int countOfPerson) {
        IntStream.range(0, countOfPerson - 1).forEach(i -> createContent());
    }

    private void createContent(){
        if (contentList.isEmpty()) {
            contentList.add(randomBoolean());
            return;
        }

        Boolean prevLine = contentList.get(contentList.size()-1);
        if(!prevLine) {
            contentList.add(randomBoolean());
            return;
        }

        contentList.add(false);
    }

    private boolean randomBoolean() {
        Random rd = new Random();
        return rd.nextBoolean();
    }

    public List<Boolean> getContents() {
        return contentList;
    }
}
