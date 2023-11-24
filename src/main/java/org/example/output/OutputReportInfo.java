package org.example.output;

import java.io.*;

public class OutputReportInfo {
    private static final String PATH_ARCHIVE = "src\\main\\java\\org\\example\\directory\\archive\\";
    private static final String NAME_REPORT_FILE = "FILE_REPORT_GENERAL.txt";
//    public static void main(String[] args) throws IOException {
//        outputReportInfo(PATH_ARCHIVE , NAME_REPORT_FILE);
//    }

    /**
     * Выводим информацию из файла в консоль
     * @param PATH_ARCHIVE - путь к файлу
     * @param NAME_REPORT_FILE - файл REPORT
     * @throws IOException
     */
    public void outputReportInfo(String PATH_ARCHIVE, String NAME_REPORT_FILE) throws IOException {
        String reportAbsolutePath = PATH_ARCHIVE + NAME_REPORT_FILE;
        BufferedReader reader = new BufferedReader(new FileReader(reportAbsolutePath));
        String line = reader.readLine();

        while(line != null){
            System.out.println(line);
            line = reader.readLine();
        }
        reader.close();
    }
}
