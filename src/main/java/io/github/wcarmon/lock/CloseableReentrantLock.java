package io.github.wcarmon.lock;

import java.util.concurrent.locks.ReentrantLock;

/** Allows ReentrantLock in try-with-resources */
public final class CloseableReentrantLock extends ReentrantLock implements CloseableLock {

    /**
     * Example: try (var _r = stateLock.lockAsResource()) { ... use lock here ... }
     *
     * @return an {@link AutoCloseable} after lock acquired.
     */
    @Override
    public LockResource lockAsResource() {
        lock();
        return this::unlock;
    }
}
