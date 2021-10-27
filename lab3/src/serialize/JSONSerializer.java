package serialize;

import java.io.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import lab2.*;

public class JSONSerializer<T extends Worker> implements Serializer<T> {
    ObjectMapper mapper;
    Class<T> myClass;

    public JSONSerializer(Class<T> myClass) {
        mapper = new ObjectMapper();
        this.myClass = myClass;
    }

    @Override
    public void Serialize(T obj, File file) throws IOException {
        try {
            mapper.writeValue(file, obj);
        }
        catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public T Deserialize(File file) {
        try {
            return mapper.readValue(file, myClass);
        }
        catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}