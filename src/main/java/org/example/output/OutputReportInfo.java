package org.example.output;

import org.example.filter.FilterByDate;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class OutputReportInfo {
    private static final String PATH_ARCHIVE = "src\\main\\java\\org\\example\\directory\\archive\\";
    private static final String NAME_REPORT_FILE = "FILE_REPORT_GENERAL.txt";
    public static void main(String[] args) throws IOException, ParseException {
//        outputReportInfo(PATH_ARCHIVE , NAME_REPORT_FILE);

        outputReportInfo(PATH_ARCHIVE, NAME_REPORT_FILE, generateReportAmountOfTheTime(PATH_ARCHIVE, NAME_REPORT_FILE, "26112023", "27112023"));

    }
    /**
     * Выводим информацию из List в консоль
     * @param PATH_ARCHIVE - путь к файлу
     * @param NAME_REPORT_FILE - файл REPORT
     * @throws IOException
     */
    public static void outputReportInfo(String PATH_ARCHIVE, String NAME_REPORT_FILE, List<String> list) throws IOException {
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
    public static List<String> generateReportFullInfo(String PATH_ARCHIVE, String NAME_REPORT_FILE) throws IOException{
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
     * Генерирует лист строк за определнную дату из файла REPORT
     * @param PATH_ARCHIVE
     * @param NAME_REPORT_FILE
     * @param date
     * @return
     * @throws IOException
     */
    public List<String> generateReportByDateInfo(String PATH_ARCHIVE, String NAME_REPORT_FILE, String date) throws IOException {
        FilterByDate filter = new FilterByDate();
        List<String> list = filter.filterByDate(generateReportFullInfo(PATH_ARCHIVE, NAME_REPORT_FILE),  date);

        return list;
    }

    /**
     * Метод генерирует List<String> из файла REPORT за определённый период времени
     * @param PATH_ARCHIVE
     * @param NAME_REPORT_FILE
     * @param date1 - переданная первая дата в виде строки
     * @param date2 - переданная вторая дата в виде строки
     * @return
     * @throws IOException
     * @throws ParseException
     */
    public static List<String> generateReportAmountOfTheTime(String PATH_ARCHIVE, String NAME_REPORT_FILE, String date1, String date2) throws IOException, ParseException {
        FilterByDate filter = new FilterByDate();
        List<String> listFullInfo = generateReportFullInfo(PATH_ARCHIVE, NAME_REPORT_FILE);
        List<String> listAmountOfTheTime = filter.generateListAmountOfTime(date1, date2);
        List<String> list = new ArrayList<>();

        for(String str1 : listFullInfo){
            for(String str2 : listAmountOfTheTime){
                if(str1.contains(str2)){
                    list.add(str1);
                }
            }
        }
        return list;
    }
}
