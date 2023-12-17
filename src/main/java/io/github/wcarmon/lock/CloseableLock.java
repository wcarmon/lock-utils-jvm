package io.github.wcarmon.lock;

import java.util.concurrent.locks.Lock;

/** Helps retrieve a Lock compatible with try-with-resources. */
public interface CloseableLock extends Lock {

    /**
     * Example: try (var _r = stateLock.lockAsResource()) { ... use lock here ... }
     *
     * @return an {@link AutoCloseable} after lock acquired.
     */
    LockResource lockAsResource();
}
