package org.example.update;

import org.example.write.WriteToReportFile;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.List;

public class UpdateReportFile {
//    private static final String PATH_INPUT = "src\\main\\java\\org\\example\\directory\\input\\";
//    private static final String PATH_ARCHIVE = "src\\main\\java\\org\\example\\directory\\archive\\";
//    private static final String NAME_REPORT_FILE = "FILE_REPORT_GENERAL.txt";
    static WriteToReportFile write = new WriteToReportFile();
//
//    public static void main(String[] args) {
//        UpdateReportFile updateReportFile = new UpdateReportFile();
//        updateReportFile.updateReportFile(PATH_ARCHIVE,NAME_REPORT_FILE, PATH_INPUT);
//    }
    /**
     * В случае если файл пустой(не имеет записей), записывает строку,
     * иначе продолжает записывать инфо в след строки
     * @param PATH_ARCHIVE
     * @param NAME_REPORT_FILE
     * @param PATH_INPUT
     */
    public void updateReportFile(String PATH_ARCHIVE, String NAME_REPORT_FILE, String PATH_INPUT){
        try(BufferedWriter buffer = new BufferedWriter(new FileWriter(PATH_ARCHIVE + NAME_REPORT_FILE, true))){
            File file = new File(PATH_ARCHIVE + NAME_REPORT_FILE);

            if(!isEmpty(file)){
                List<String> list = write.castingToString(PATH_INPUT);
                for(String str :list){
                    buffer.write(str);
                    buffer.newLine();
                }

            }else if(isEmpty(file)) {
                write.writeToReportFile(PATH_ARCHIVE, NAME_REPORT_FILE, PATH_INPUT);
            }
        }catch (IOException e){
            throw new RuntimeException(e);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Проверка файла на пустоту
     * @param file
     * @return
     */
    public boolean isEmpty(File file){
        return file.length() == 0;
    }

}
