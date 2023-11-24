package org.example;

import org.example.user.selection.UserSelection;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        UserSelection selection = new UserSelection();
        selection.userSelection();

    }
}