package patterns.solid.liscov.task1.impl1;

import java.util.HashMap;
import java.util.Map;

public class InMemoryS3Client implements MutableObjectStorage {
    private final Map<String, Map<String, byte[]>> store = new HashMap<>();

    @Override
    public void putObject(String bucket, String key, byte[] data) {
        store.computeIfAbsent(bucket, b -> new HashMap<>()).put(key, data);
    }

    @Override
    public byte[] getObject(String bucket, String key) {
        Map<String, byte[]> b = store.get(bucket);
        return b == null ? null : b.get(key);
    }

    @Override
    public void deleteObject(String bucket, String key) {
        Map<String, byte[]> b = store.get(bucket);
        if (b != null) b.remove(key);
    }
}