package io.github.wcarmon.lock;

/** A Lock compatible with try-with-resources */
@FunctionalInterface
public interface LockResource extends AutoCloseable {

    /** No checked exceptions */
    @Override
    void close();
}
