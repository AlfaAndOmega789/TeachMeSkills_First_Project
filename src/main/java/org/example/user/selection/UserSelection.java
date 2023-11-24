package org.example.user.selection;

import org.example.create.CreateFileReport;
import org.example.output.OutputReportInfo;
import org.example.update.UpdateReportFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserSelection {
    private static final String PATH_INPUT = "src\\main\\java\\org\\example\\directory\\input\\";
    private static final String PATH_ARCHIVE = "src\\main\\java\\org\\example\\directory\\archive\\";
    private static final String NAME_REPORT_FILE = "FILE_REPORT_GENERAL.txt";
    static boolean someValue = true;
    /**
     * Метод просит ввести пользователя значение в консоль,
     * в зависимости от выбора пользователя соверащает след. действия
     * 1 - вызов операции парсинга файлов перевода из input
     * 2 - вызов операции вывода списка всех переводов из файла-отчета
     * @throws IOException
     */
    public void userSelection() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Выберете вариант из двух доступных:\n" +
                "1. Вызов операции парсинга файлов перевода из input\n" +
                "2. Вызов операции вывода списка всех переводов из файла-отчета.\n" +
                "Для выбора операции нажмите 1 или 2 соответственно: "
        );

        while(someValue){
            int enteredUser = Integer.parseInt(reader.readLine());

            if(enteredUser == 1){
                CreateFileReport createFile = new CreateFileReport();
                createFile.createFileReport(PATH_ARCHIVE, NAME_REPORT_FILE);

                UpdateReportFile updateReportFile = new UpdateReportFile();
                updateReportFile.updateReportFile(PATH_ARCHIVE,NAME_REPORT_FILE, PATH_INPUT);
                break;

            }else if(enteredUser == 2){
                OutputReportInfo output = new OutputReportInfo();
                output.outputReportInfo(PATH_ARCHIVE , NAME_REPORT_FILE);
                break;
            }else{
                System.out.print("Вы ввели значение отличное от 1 или 2, повторите ввод снова:");
            }
        }
    }
}
