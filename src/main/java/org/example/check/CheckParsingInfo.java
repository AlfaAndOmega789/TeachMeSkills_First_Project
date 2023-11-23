package org.example.check;

import java.util.List;

public class CheckParsingInfo {
    public String checkAll(List<String> list){
        String resultOperation = null;

        if(!checkLengthBilling(list.get(0)) &&
                !checkLengthBilling(list.get(3))){
            resultOperation = "Неуспешно. Некорректный номер счета отправителя или получателя.";
        }else if(!checkTransferAmount(list.get(3))){
            resultOperation = "Неуспешно. Указана некорректная сумма перевода.";
        }else if(!checkAmountLength(list.get(3))){
            resultOperation = "Неуспешно. Не заполнено поле суммы.";
        }else if(!checkTheRecipientBilling(
                list.get(1), list.get(3))){
            resultOperation = "Неуспешно. Сумма перевода превышает кол-во денежных средств на счете отправителя";
        }else{
            resultOperation = "Успешно.";
        }
        return resultOperation;
    }
    /**
     * Проверка длины строки, использ. для номера счета
     * @param str
     * @return
     */
    public boolean checkLengthBilling(String str){
        return str.length() == 11;
    }
    /**
     * Проверка суммы перевода на отрицательное значение
     * @param str
     * @return
     */
    public boolean checkTransferAmount(String str){
        return Integer.parseInt(str) > 0 ;
    }
    /**
     * Проверка на отсутствие заполненого поля(суммы перевода)
     * @param str
     * @return
     */
    public boolean checkAmountLength(String str){
        return str.length() == 0;
    }
    /**
     * Cравнение суммы перевода с количеством денежных средств на счёте отправителя
     * @param str1
     * @param str3
     * @return
     */
    public boolean checkTheRecipientBilling(String str1, String str3){
        return Double.parseDouble(str1) > Double.parseDouble(str3);
    }
}
