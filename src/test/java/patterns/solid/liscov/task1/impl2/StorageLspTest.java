package patterns.solid.liscov.task1.impl2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNull;

public class StorageLspTest {

    @Test
    void deleteObject_works_for_any_ObjectStorage_inmemory() {
        ObjectStorage s = new SafeDeletingStorageAdapter(new InMemoryS3Client());
        s.putObject("b", "k", new byte[]{1});
        assertDoesNotThrow(() -> s.deleteObject("b", "k"));
        assertNull(s.getObject("b", "k"));
    }

    @Test
    void substituting_glacier_does_not_break_delete_contract() {
        ObjectStorage s = new SafeDeletingStorageAdapter(new GlacierS3Client());
        s.putObject("b", "k", new byte[]{1});
        assertDoesNotThrow(() -> s.deleteObject("b", "k"));
    }
}