package serialize;

import lab2.Company;
import lab2.Worker;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class TXTSerializer implements Serializer<Company> {

    @Override
    public void Serialize(Company obj, File file) throws IOException {
        try (FileWriter fw = new FileWriter(file)) {
            String str = ((lab2.Company) obj).toString();
            fw.write(str);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Company Deserialize(File file) throws IOException {
        try (FileReader fr = new FileReader(file)) {

            String str = "";
            String name = "", lastname = "", age = "0";
            int c;
            while ((c = fr.read()) != -1)
                str += (char) c;
            List<Worker> work = new ArrayList<Worker>();

            String[] values = str.split(" ");
            for (int i = 0; i < values.length; i++) {

                if (values[i].equals("FirstName") || values[i].equals("\n[FirstName")) {
                    name = values[i + 2];
                }
                if (values[i].equals("LastName")) {
                    lastname = values[i + 2];
                    age = values[i + 3];
                    work.add(new Worker(Integer.parseInt(age), lastname, name));
                }


            }
            System.out.println(values.length);
            return new Company(Integer.parseInt(values[1]), values[5], work);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}