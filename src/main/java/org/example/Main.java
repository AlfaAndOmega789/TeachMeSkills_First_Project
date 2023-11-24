package org.example;

import org.example.create.CreateFileReport;
import org.example.update.UpdateReportFile;
import org.example.user.selection.UserSelection;
import org.example.write.WriteToReportFile;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
        UserSelection selection = new UserSelection();
        selection.userSelection();

    }
}