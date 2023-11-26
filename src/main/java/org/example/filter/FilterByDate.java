package org.example.filter;

import org.example.list.txt.GenerateListTxt;
import org.example.output.OutputReportInfo;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class FilterByDate {
//    private static final String PATH_ARCHIVE = "src\\main\\java\\org\\example\\directory\\archive\\";
//    private static final String NAME_REPORT_FILE = "FILE_REPORT_GENERAL.txt";

    public static void main(String[] args) throws IOException, ParseException {
//        OutputReportInfo output = new OutputReportInfo();
//        List<String> list = filterByDate(output.generateReportInfo(PATH_ARCHIVE, NAME_REPORT_FILE), "24112023");
//
//        for(String str : list){
//            System.out.println(str);
//        }

//        List<String> list = generateListAmountOfTime("25102023", "27112023");
//        for(String str : list){
//            System.out.println(str);
//        }
    }

    /**
     * Выводим те стркои в которых содержится переданная дата
     * @param list - лист строк содержащихся в файле REPORT
     * @param date - дата в нужном формате
     * @return
     */
    public List<String> filterByDate(List<String> list, String date){
        List<String> newList = new ArrayList<>();
        for(String str : list){
            if(str.contains(date)){
                newList.add(str);
            }
        }
        return newList;
    }

    /**
     * Генерирует List дат в виде строк в указанный промежуток времени
     * @param date1 - дата с(в виде строки)
     * @param date2 - дата по(в виде строки)
     * @return - List<String> в виде дат
     * @throws ParseException
     */
    public List<String> generateListAmountOfTime(String date1, String date2) throws ParseException {
        List<String> listDate = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
        Date date = sdf.parse(date1);
        listDate.add(sdf.format(date));

        while(true){
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.add(Calendar.DATE, 1);
            date = c.getTime();
            listDate.add(sdf.format(date));

            if(sdf.format(date).equals(date2)){
                break;
            }
        }
        return listDate;
    }
}
