package org.example.output;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class OutputReportInfo {
//    private static final String PATH_ARCHIVE = "src\\main\\java\\org\\example\\directory\\archive\\";
//    private static final String NAME_REPORT_FILE = "FILE_REPORT_GENERAL.txt";
//    public static void main(String[] args) throws IOException {
//        outputReportInfo(PATH_ARCHIVE , NAME_REPORT_FILE);
//    }

    /**
     * Выводим информацию из List в консоль
     * @param PATH_ARCHIVE - путь к файлу
     * @param NAME_REPORT_FILE - файл REPORT
     * @throws IOException
     */
    public void outputReportInfo(String PATH_ARCHIVE, String NAME_REPORT_FILE) throws IOException {
        OutputReportInfo output = new OutputReportInfo();
        List<String> list = generateReportInfo(PATH_ARCHIVE, NAME_REPORT_FILE);

        for(String str : list){
            System.out.println(str);
        }
    }

    /**
     * Генерирует лист строк который содержится в файле REPORT
     * @param PATH_ARCHIVE
     * @param NAME_REPORT_FILE
     * @return
     * @throws IOException
     */
    public List<String> generateReportInfo(String PATH_ARCHIVE, String NAME_REPORT_FILE) throws IOException{
        List<String> list = new ArrayList<>();
        String reportAbsolutePath = PATH_ARCHIVE + NAME_REPORT_FILE;
        BufferedReader reader = new BufferedReader(new FileReader(reportAbsolutePath));
        String line = reader.readLine();

        while(line != null){
            list.add(line);
            line = reader.readLine();
        }
        reader.close();

        return list;
    }
}
