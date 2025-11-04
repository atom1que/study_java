package patterns.solid.liscov.task1.impl1;

public interface MutableObjectStorage extends ObjectStorage {
    void deleteObject(String bucket, String key);
}