package org.example;

import org.example.create.CreateFileReport;
import org.example.write.WriteToReportFile;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {
    private static final String PATH_INPUT = "src\\main\\java\\org\\example\\directory\\input\\";
    private static final String PATH_ARCHIVE = "src\\main\\java\\org\\example\\directory\\archive\\";
    private static final String NAME_REPORT_FILE = "FILE_REPORT_GENERAL.txt";
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
//        CreateFileReport createFile = new CreateFileReport();
//        createFile.createFileReport(PATH_ARCHIVE, NAME_REPORT_FILE);

        WriteToReportFile write = new WriteToReportFile();
        write.writeToReportFile(PATH_ARCHIVE, NAME_REPORT_FILE, PATH_INPUT);
    }
}