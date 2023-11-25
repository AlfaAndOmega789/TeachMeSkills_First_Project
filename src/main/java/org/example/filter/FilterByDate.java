package org.example.filter;

import org.example.list.txt.GenerateListTxt;
import org.example.output.OutputReportInfo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FilterByDate {
    private static final String PATH_ARCHIVE = "src\\main\\java\\org\\example\\directory\\archive\\";
    private static final String NAME_REPORT_FILE = "FILE_REPORT_GENERAL.txt";

//    public static void main(String[] args) throws IOException {
//        OutputReportInfo output = new OutputReportInfo();
//        List<String> list = filterByDate(output.generateReportInfo(PATH_ARCHIVE, NAME_REPORT_FILE), "24112023");
//
//        for(String str : list){
//            System.out.println(str);
//        }
//    }

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

}
