package patterns.solid.liscov.task1.cause;

public class GlacierS3Client implements ObjectStorage {
    @Override
    public void putObject(String bucket, String key, byte[] data) {
    }

    @Override
    public byte[] getObject(String bucket, String key) {
        return null;
    }

    // нарушение LCP, OCP, SRP
    @Override
    public void deleteObject(String bucket, String key) {
        throw new UnsupportedOperationException("not supported");
    }
}