package org.example.output;

import org.example.filter.FilterByDate;

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
    public void outputReportInfo(String PATH_ARCHIVE, String NAME_REPORT_FILE, List<String> list) throws IOException {

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
    public List<String> generateReportFullInfo(String PATH_ARCHIVE, String NAME_REPORT_FILE) throws IOException{
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

    /**
     * Генерирует лист срок за определнную дату из файла REPORT
     * @param PATH_ARCHIVE
     * @param NAME_REPORT_FILE
     * @param str
     * @return
     * @throws IOException
     */
    public List<String> generateReportByDateInfo(String PATH_ARCHIVE, String NAME_REPORT_FILE, String str) throws IOException {
        FilterByDate filter = new FilterByDate();
        List<String> list = filter.filterByDate(generateReportFullInfo(PATH_ARCHIVE, NAME_REPORT_FILE),  str);

        return list;
    }
}
