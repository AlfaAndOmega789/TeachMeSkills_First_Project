package org.example.user.selection;

import org.example.check.CheckParsingInfo;
import org.example.create.CreateFileReport;
import org.example.database.WorkWithDatabase;
import org.example.filter.FilterByDate;
import org.example.list.txt.GenerateListTxt;
import org.example.output.OutputReportInfo;
import org.example.parser.DOMProjectParser;
import org.example.update.UpdateReportFile;
import org.w3c.dom.ls.LSOutput;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class UserSelection {
    private static  String PATH_INPUT = "src\\main\\java\\org\\example\\directory\\input\\";
    private static  String PATH_ARCHIVE = "src\\main\\java\\org\\example\\directory\\archive\\";
    private static final String NAME_REPORT_FILE = "FILE_REPORT_GENERAL.txt";
    static boolean someValue = true;
    /**
     * Метод просит ввести пользователя значение в консоль,
     * в зависимости от выбора пользователя соверащает след. действия
     * 1 - вызов операции парсинга файлов перевода из input
     * 2 - вызов операции вывода списка всех переводов из файла-отчета
     * @throws IOException
     */
    public void userSelection() throws IOException, ParseException, SQLException, ParserConfigurationException, SAXException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Выберете вариант из двух доступных:\n" +
                "1. Вызов операции парсинга файлов перевода из input\n" +
                "2. Вызов операции вывода списка всех переводов из файла-отчета.\n" +
                "Для выбора операции нажмите 1 или 2 соответственно: "
        );

        while(someValue){
            int enteredUser = Integer.parseInt(reader.readLine());
            System.out.println();

            if(enteredUser == 1){
                CreateFileReport createFile = new CreateFileReport();
                createFile.createFileReport(PATH_ARCHIVE, NAME_REPORT_FILE);

                UpdateReportFile updateReportFile = new UpdateReportFile();
                updateReportFile.updateReportFile(PATH_ARCHIVE,NAME_REPORT_FILE, PATH_INPUT);
                break;

            }else if(enteredUser == 2){
                OutputReportInfo output = new OutputReportInfo();


                System.out.print("Выберете вариант из трёх доступных:\n" +
                        "1. Вызов  операций переводов из файла-отчета за определенную дату.\n" +
                        "2. Вызов всех операций переводов из файла-отчета.\n" +
                        "3. Вызов всех операций переводов из файла-отчета за определенный период времени. \n" +
                        "4. Создание и загрузка информации из файла REPORT в таблицу reports(database - mydbproject). \n" +
                        "Для выбора операции нажмите 1, 2, 3 или 4 соответственно: "
                );
                int newEnteredUser = Integer.parseInt(reader.readLine());
                System.out.println();

                if(newEnteredUser == 1){
                    System.out.print("Введите дату формата ddMMyyyy: ");
                    String date = reader.readLine();

                    List<String> outputList = output.generateReportByDateInfo(PATH_ARCHIVE, NAME_REPORT_FILE, date);
                    output.outputReportInfo(PATH_ARCHIVE , NAME_REPORT_FILE, outputList);
                    break;

                }else if(newEnteredUser == 2){
                    List<String> outputList = output.generateReportFullInfo(PATH_ARCHIVE, NAME_REPORT_FILE);

                    output.outputReportInfo(PATH_ARCHIVE , NAME_REPORT_FILE, outputList);
                    break;
                }else if(newEnteredUser == 3){
                    System.out.print("Введите первую дату формата ddMMyyyy: ");
                    String date1 = reader.readLine();
                    System.out.println();

                    System.out.print("Введите вторую дату формата ddMMyyyy: ");
                    String date2 = reader.readLine();
                    List<String> list = output.generateReportAmountOfTheTime(PATH_ARCHIVE, NAME_REPORT_FILE, date1,date2);

                    output.outputReportInfo(PATH_ARCHIVE, NAME_REPORT_FILE, list);
                    break;
                }
            }else if(enteredUser == 4){ // пока что не работает
                OutputReportInfo output = new OutputReportInfo();
                WorkWithDatabase workDB = new WorkWithDatabase();
                workDB.createTable();

                List<String> list = output.generateReportFullInfo(PATH_ARCHIVE,NAME_REPORT_FILE);

                for(String str : list){
                    workDB.addInfoToTable(str);
                }

            } else{
                System.out.print("Вы ввели значение отличное от 1, 2 или 3, повторите ввод снова:");
            }
        }
    }
}
