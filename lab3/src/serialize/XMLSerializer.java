package serialize;

import java.io.*;
import java.io.IOException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import lab2.*;

public class XMLSerializer<T extends Worker> implements Serializer<T> {

    XmlMapper mapper ;
    Class<T> myClass;

    public XMLSerializer(Class<T> myClass) {
  mapper = new XmlMapper();
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
    public T Deserialize(File file) throws IOException {
        try {
            return mapper.readValue(file, myClass);
        }
        catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}