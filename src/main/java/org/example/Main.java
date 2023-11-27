package org.example;

import org.example.user.selection.UserSelection;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws IOException, ParseException, SQLException, ParserConfigurationException, SAXException {
        UserSelection selection = new UserSelection();
        selection.userSelection();
    }
}