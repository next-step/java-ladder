package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FirstClassListTest {
    static final class TestObject {
        public static final TestObject OBJ1 = new TestObject(1);
        public static final TestObject OBJ2 = new TestObject(2);

        private final int value;
        private boolean flag;

        private TestObject(final int value) {
            this.value = value;
            this.flag = true;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TestObject that = (TestObject) o;
            return value == that.value;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }

        @Override
        public String toString() {
            return "TestObject{" +
                    "value=" + value +
                    '}';
        }
    }

    static final class TestList extends FirstClassList<TestObject> {
        public TestList(List<TestObject> collection) {
            super(collection);
        }

        public static TestList of(TestObject ... elements) {
            return new TestList(Arrays.asList(elements));
        }
    }

    @Test
    public void create() {
        assertThat(TestList.of(TestObject.OBJ1, TestObject.OBJ2)).isEqualTo(TestList.of(TestObject.OBJ1, TestObject.OBJ2));
    }

    @Test
    public void collect() {
        assertThat(TestList.of(TestObject.OBJ1, TestObject.OBJ2).collect()).containsExactly(TestObject.OBJ1, TestObject.OBJ2);
    }

    @Test
    public void stream() {
        assertThat(TestList.of(TestObject.OBJ1, TestObject.OBJ2).stream()).containsExactly(TestObject.OBJ1, TestObject.OBJ2);
    }

    @Test
    public void foreach() {
        TestList testCollection = TestList.of(TestObject.OBJ1, TestObject.OBJ2);
        testCollection.forEach(obj -> obj.flag = false);
        assertThat(testCollection.stream().filter(obj -> obj.flag).findAny()).isEmpty();
    }

    @Test
    public void size() {
        assertThat(TestList.of(TestObject.OBJ1, TestObject.OBJ2).size()).isEqualTo(2);
    }


    @Test
    public void get() {
        assertThat(TestList.of(TestObject.OBJ1, TestObject.OBJ2).get(0)).isEqualTo(TestObject.OBJ1);
    }

    @Test
    public void hasSameSize() {
        TestList testList = TestList.of(TestObject.OBJ1, TestObject.OBJ2);
        FirstClassList<Integer> testIntList = new FirstClassList<>(List.of(0, 1)) {};
        FirstClassList<Long> testLongList = new FirstClassList<>(List.of(0L, 1L, 2L)) {};

        assertThat(testList.hasSameSize(testIntList)).isTrue();
        assertThat(testList.hasSameSize(testLongList)).isFalse();
    }
}
