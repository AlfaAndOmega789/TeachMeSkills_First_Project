package org.example.write;

import org.example.check.CheckParsingInfo;
import org.example.create.CreateFileReport;
import org.example.list.txt.GenerateListTxt;
import org.example.parser.DOMProjectParser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WriteToReportFile {
//    private static final String PATH_ARCHIVE = "src\\main\\java\\org\\example\\directory\\archive\\";
//    private static final String PATH_INPUT = "src\\main\\java\\org\\example\\directory\\input\\";
//    private static final String NAME_REPORT_FILE = "FILE_REPORT_GENERAL.txt";
    static DOMProjectParser dom = new DOMProjectParser();
    static CheckParsingInfo check = new CheckParsingInfo();
    static GenerateListTxt generate = new GenerateListTxt();

    /**
     * Метод записывает строку в  файл Report(каталог archive)
     * @param PATH_ARCHIVE
     * @param NAME_REPORT_FILE -
     * @param PATH_INPUT -
     * @throws IOException
     * @throws ParserConfigurationException
     * @throws SAXException
     */
    public void writeToReportFile(String PATH_ARCHIVE, String NAME_REPORT_FILE, String PATH_INPUT){
        String reportAbsolutePath = PATH_ARCHIVE + NAME_REPORT_FILE;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(reportAbsolutePath, StandardCharsets.UTF_8))) {
            List<String> list = castingToString(PATH_INPUT);

            for(String str: list){
                writer.write(str);
                writer.newLine();
            }

        }catch (IOException e){
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Метод записывает вычитанную информацию из файла(каталог input) .txt в строку
     * @param PATH_INPUT
     * @return спарешнный данные в виде строки, строка будет записана в файл
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     */
    public List<String> castingToString(String PATH_INPUT) throws ParserConfigurationException, IOException, SAXException {
        List<String> list = generate.listFileNamesTxt(PATH_INPUT);
        List<String> result = new ArrayList<>();

        for(int i = 0; i < list.size();i++){
            String inputAbsolutePath = PATH_INPUT + list.get(i);
            List<String> listParse = dom.parsingFile(inputAbsolutePath);

            result.add(getCurrentDate() + " | " + list.get(i) + " | перевод с " +
                    listParse.get(0) + " на " + listParse.get(2) + " " +
                    listParse.get(3) + " | " + check.checkAll(listParse));
        }

        return result;
    }
    /**
     * Метод будет использован в файле-отчете(дата совершения операции)
     * @return - возвращает строку в виде даты в нужном формате
     */
    public String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy-HH:mm");
        return dateFormat.format(new Date());
    }

}
