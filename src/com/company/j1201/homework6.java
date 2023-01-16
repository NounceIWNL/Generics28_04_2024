package com.company.j1201;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystemAlreadyExistsException;

public class homework6 {

    public static void main(String[] args) throws FileNotFoundException {
        XmlReader[] xmlReaders = new XmlReader[5];
        for (int i=0; i<5; i++)
            xmlReaders[i] = new XmlReader();
        runner(xmlReaders);
    }

    public static void runner(XmlReader[] xmlReaders) throws FileNotFoundException {
        for (XmlReader xmlReader:xmlReaders) {
            try {

                xmlReader.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
            catch (FileSystemAlreadyExistsException e){
                throw new FileNotFoundException();
            }
        }
    }
}