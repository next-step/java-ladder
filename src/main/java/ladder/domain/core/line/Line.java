package ladder.domain.core.line;


import ladder.domain.core.line.name.BaseName;
import ladder.domain.core.line.name.Names;
import ladder.ui.result.DisplayResult;

public interface Line {

    default int indexOf(String name) {
        throw new UnsupportedOperationException();
    }

    default int indexOf(int index) {
        throw new UnsupportedOperationException();
    }

    default String getResult(int index) {
        throw new UnsupportedOperationException();
    }

    int getWidth();

    default Names<? extends BaseName> getNames(){
        throw new UnsupportedOperationException();
    }

    DisplayResult toDisplayResult();
}
