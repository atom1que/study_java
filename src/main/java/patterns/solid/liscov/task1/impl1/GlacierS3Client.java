package patterns.solid.liscov.task1.impl1;

public class GlacierS3Client implements ObjectStorage {
    @Override
    public void putObject(String bucket, String key, byte[] data) {}

    @Override
    public byte[] getObject(String bucket, String key) { return null; }
}