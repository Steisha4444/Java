package main;

import lab2.*;
import serialize.*;

import java.io.IOException;
import java.io.File;
import java.util.Arrays;
import java.util.List;

public class Program {

    public static void main(String[] args) {

        String myDir = new File("").getAbsolutePath() + "\\src\\main";

//        Serializer<Teacher> mySerJSON = new JSONSerializer<Teacher>(Teacher.class);
//        Teacher TeacherJSON = new Teacher(25, "Fluf", "Kate", 1, 23000, "math");
//        try {
//            File json = new File(myDir, "Teacher.json");
//            mySerJSON.Serialize(TeacherJSON, json);
//            TeacherJSON = mySerJSON.Deserialize(json);
//            System.out.println(TeacherJSON);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        Serializer<Assistant> mySerXML = new XMLSerializer<Assistant>(Assistant.class);
//        Assistant AssistantXML = new Assistant(22, "Shelest", "Liara", 2, 13000, "literature", 2.5);
//        try {
//            File xml = new File(myDir, "Assistant.xml");
//            mySerXML.Serialize(AssistantXML, xml);
//            AssistantXML = mySerXML.Deserialize(xml);
//            System.out.println(AssistantXML);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        Serializer<Worker> mySerTxt = new TXTSerializer();
//        Worker WorkerTXT = new Worker(34, "Merlin", "Den");
//        try {
//            File txt = new File(myDir, "Worker.txt");
//            mySerTxt.Serialize(WorkerTXT, txt);
//            WorkerTXT = mySerTxt.Deserialize(txt);
//            System.out.println(WorkerTXT);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        List<Worker> School = Arrays.asList(
                new Worker(25, "Daniluk", "Bonny"),
                new Worker(23, "Ken", "Fluffy"),
                new Worker(31, "Marsel", "Endy"),
                new Worker(35, "Lem", "Luna"),
                new Worker(41, "Chase", "Jasper")
        );

      Serializer<Company> mySerrTxt = new TXTSerializer();
       Company CompanyTXT = new Company(1, "ITSupport", School);
     try {
            File txt = new File(myDir, "Company.txt");
          mySerrTxt.Serialize(CompanyTXT, txt);
           CompanyTXT = mySerrTxt.Deserialize(txt);
         System.out.println("TXT");
           System.out.println(CompanyTXT);
       } catch (IOException e) {
            e.printStackTrace();
       }

        Serializer<Company> mySerrJSON = new JSONSerializer<Company>(Company.class);
        Company CompanyJSON = new Company(25, "Fluf", School);
        try {
            File json = new File(myDir, "Company.json");
            mySerrJSON.Serialize(CompanyJSON, json);
            CompanyJSON = mySerrJSON.Deserialize(json);
            System.out.println("JSON");
            System.out.println(CompanyJSON);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Serializer<Company> mySerXML = new XMLSerializer<Company>(Company.class);
        Company CompanyXML = new Company(21, "Delivery", School);
       try {
           File xml = new File(myDir, "Company.xml");
            mySerXML.Serialize(CompanyXML, xml);
           System.out.println("XML");
           CompanyXML = mySerXML.Deserialize(xml);
            System.out.println(CompanyXML);
      } catch (IOException e) {
            e.printStackTrace();
       }

    }
}