package patterns.solid.liscov.task1.impl1;

public interface ObjectStorage {
    void putObject(String bucket, String key, byte[] data);
    byte[] getObject(String bucket, String key);
}