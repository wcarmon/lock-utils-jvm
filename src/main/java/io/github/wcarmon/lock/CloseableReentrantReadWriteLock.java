package io.github.wcarmon.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/** Allows ReentrantReadWriteLock in try-with-resources */
public final class CloseableReentrantReadWriteLock extends ReentrantReadWriteLock {

    /**
     * Example: try (var _r = stateLock.lockReadAsResource()) { ... use lock here ... }
     *
     * @return an {@link AutoCloseable} after lock acquired.
     */
    public LockResource lockReadAsResource() {
        readLock().lock();
        return () -> readLock().unlock();
    }

    /**
     * Example: try (var _w = stateLock.lockWriteAsResource()) { ... use lock here ... }
     *
     * @return an {@link AutoCloseable} after lock acquired.
     */
    public LockResource lockWriteAsResource() {
        writeLock().lock();
        return () -> writeLock().unlock();
    }
}
