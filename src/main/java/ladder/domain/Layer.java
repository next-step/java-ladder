package ladder.domain;

import ladder.service.RandomBoolean;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Layer {
    private final List<Handle> handles;

    private Layer(List<Handle> handles) {
        this.handles = handles;
    }

    public static Layer valueOf(int line, RandomBoolean randomBoolean) {
        List<Handle> result = new ArrayList<>();
        result.add(Handle.valueOf(randomBoolean));
        for (int i = 1; i < line - 1; i++) {
            result.add(Handle.valueOf(result.get(i - 1), randomBoolean));
        }
        return new Layer(result);
    }

    public static Layer valueOf(List<Handle> handles) {
        return new Layer(handles);
    }

    public int nextLine(int nowLine) {
        if (hasLeftHandle(nowLine)) {
            return nowLine - 1;
        }
        if (hasRightHandle(nowLine)) {
            return nowLine + 1;
        }
        return nowLine;
    }

    public String printLayer() {
        StringBuilder sb = new StringBuilder();
        this.handles.stream()
                .forEach(handle -> sb.append("|").append(handle.printHandle()));
        sb.append("|");
        return sb.toString();
    }

    private boolean hasLeftHandle(int line) {
        if (line <= 0) {
            return false;
        }
        if (handles.get(line - 1).isExist()) {
            return true;
        }
        return false;
    }

    private boolean hasRightHandle(int line) {
        if (line >= handles.size()) {
            return false;
        }
        if (handles.get(line).isExist()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Layer layer = (Layer) o;
        return Objects.equals(handles, layer.handles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(handles);
    }
}
