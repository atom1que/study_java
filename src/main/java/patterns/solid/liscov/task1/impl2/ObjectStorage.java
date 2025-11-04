package patterns.solid.liscov.task1.impl2;

public interface ObjectStorage {
    void putObject(String bucket, String key, byte[] data);
    byte[] getObject(String bucket, String key);
    void deleteObject(String bucket, String key);
}