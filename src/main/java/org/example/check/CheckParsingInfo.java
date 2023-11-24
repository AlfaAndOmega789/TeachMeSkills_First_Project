package org.example.check;

import java.util.List;

public class CheckParsingInfo {

    public static void main(String[] args) {
        CheckParsingInfo check = new CheckParsingInfo();
        System.out.println(check.checkLengthBilling("1111-22222"));
    }

    /**
     * Вызов всех проверок
     * @param list - спаршенные данные
     * @return
     *
     * 0. Номер счёта отправителя
     * 1. Сумма денежных средств на счёте отправителя
     * 2. Номер счёта получателя
     * 3. Сумма перевода
     */
    public String checkAll(List<String> list){
        String resultOperation = null;

        if(!checkLengthBilling(list.get(0)) ||
                !checkLengthBilling(list.get(2))){
            resultOperation = "Неуспешно. Некорректный номер счета отправителя или получателя.";
        }else if(!checkTransferAmount(list.get(3))){
            resultOperation = "Неуспешно. Указана некорректная сумма перевода.";
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
        return Integer.parseInt(str) > 0;
    }
    /**
     * Cравнение суммы перевода с количеством денежных средств на счёте отправителя
     * @param str0
     * @param str2
     * @return
     */
    public boolean checkTheRecipientBilling(String str0, String str2){
        return Double.parseDouble(str0) >= Double.parseDouble(str2);
    }
}
