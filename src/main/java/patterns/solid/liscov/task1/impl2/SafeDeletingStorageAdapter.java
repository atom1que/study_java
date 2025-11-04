package patterns.solid.liscov.task1.impl2;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SafeDeletingStorageAdapter implements ObjectStorage {

    private final ObjectStorage delegate;

    public SafeDeletingStorageAdapter(ObjectStorage delegate) {
        this.delegate = delegate;
    }


    @Override
    public void putObject(String bucket, String key, byte[] data) {
        delegate.putObject(bucket, key, data);
    }

    @Override
    public byte[] getObject(String bucket, String key) {
        return delegate.getObject(bucket, key);
    }

    @Override
    public void deleteObject(String bucket, String key) {
        try {
            delegate.deleteObject(bucket, key);
        } catch (UnsupportedOperationException e) {
            log.error("Delete not supported for this storage, skipping");
        }
    }
}
