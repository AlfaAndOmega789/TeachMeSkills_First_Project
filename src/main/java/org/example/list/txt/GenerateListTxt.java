package org.example.list.txt;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GenerateListTxt {
//    public static void main(String[] args) {
//
//        for(String str : listFileNamesTxt("src\\main\\java\\org\\example\\directory\\input\\")){
//            System.out.println(str);
//        }
//    }
    /**
     * Записывает название файлов из переданного каталога в List
     * @param PATH_INPUT
     * @return
     */
    public List<String> listFileNamesTxt(String PATH_INPUT){
        List<String> list = new ArrayList<>();
        File directory = new File(PATH_INPUT);

        if(directory.exists() && directory.isDirectory()){
            File[] files = directory.listFiles();

            if(files != null){
                for(File file : files){
                    if(file.isFile() && file.getName().toLowerCase().endsWith(".txt")){
                        list.add(file.getName());
                    }
                }
            }
        }
        return list;
    }
}
