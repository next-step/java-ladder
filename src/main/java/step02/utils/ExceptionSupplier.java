package step02.utils;

public interface ExceptionSupplier<T> {
    T get() throws Exception;

    public static <T> T wrap(ExceptionSupplier<T> z) {
        try {
            return z.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

