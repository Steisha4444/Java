package serialize;

import lab2.*;
import java.io.IOException;
import java.io.File;

public interface Serializer<T extends Worker> {
    void Serialize(T obj, File file) throws IOException;
    T Deserialize(File file) throws IOException;
}