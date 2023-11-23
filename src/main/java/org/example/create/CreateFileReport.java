package org.example.create;

import java.io.File;
import java.io.IOException;

public class CreateFileReport {

    /**
     * Создаем файл REPORT в переданном каталоге
     * @param PATH_ARCHIVE - путь к каталогу
     * @param NAME_REPORT_FILE - имя файла
     * @throws IOException
     */
    public void createFileReport(String PATH_ARCHIVE, String NAME_REPORT_FILE) throws IOException {
        File file = new File(PATH_ARCHIVE + NAME_REPORT_FILE);
        if(file.createNewFile()){
            System.out.println("Файл создан!");
        }else{
            System.out.println("Файл уже существует!");
        }
    }
}
