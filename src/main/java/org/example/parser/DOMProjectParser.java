package org.example.parser;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DOMProjectParser {
    private static final String PATH_INPUT = "src\\main\\java\\org\\example\\directory\\input\\";
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        List<String> list = parsingFile(PATH_INPUT + "first.txt");
        for(String str : list){
            System.out.println(str);
        }
    }

    /**
     * Метод парсит xml файлы и возвращает list
     * @param - путь к каталогу(PATH_ARCHIVE) + имя файла(NAME_REPORT_FILE)
     * @return - возвращает list с четырьмя значениями в указанном порядке
     * 1. Номер счёта отправителя
     * 2. Сумма денежных средств на счёте отправителя
     * 3. Номер счёта получателя
     * 4. Сумма перевода
     */
    public static List<String> parsingFile(String inputAbsolutePath) throws ParserConfigurationException, IOException, SAXException {
        List<String> list = new ArrayList<>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File(inputAbsolutePath));

        Node transferMoneyRequestNode = document.getFirstChild();
        NodeList transferMoneyRequestChilds = transferMoneyRequestNode.getChildNodes();

        Node senderNode = null;
        Node receiverNode = null;
        Node transferNode = null;

        for(int i = 0; i < transferMoneyRequestChilds.getLength();i++){

            if(transferMoneyRequestChilds.item(i).getNodeType() != Node.ELEMENT_NODE){
                continue;
            }

            switch (transferMoneyRequestChilds.item(i).getNodeName()){
                case "Sender": {
                    senderNode = transferMoneyRequestChilds.item(i);
                }break;
                case "Receiver": {
                    receiverNode = transferMoneyRequestChilds.item(i);
                }break;
                case "Transfer": {
                    transferNode = transferMoneyRequestChilds.item(i);
                }break;
            }
        }

        NodeList senderChilds = senderNode.getChildNodes();
        String senderAccountNumber = null;
        String amountInTheSenderAccount = null;

        for(int i = 0; i < senderChilds.getLength();i++){
            if(senderChilds.item(i).getNodeType() != Node.ELEMENT_NODE){
                continue;
            }
            if(senderChilds.item(i).getNodeName().equals("SenderAccountNumber")){
                senderAccountNumber = senderChilds.item(i).getTextContent(); //номер счёта отправителя
                list.add(senderAccountNumber);
            }
            if(senderChilds.item(i).getNodeName().equals("USAmountOfMoneyInTheAccountSender")){
                amountInTheSenderAccount = senderChilds.item(i).getTextContent(); //кол-во денежных средств на счёте отправителя
                list.add(amountInTheSenderAccount);
            }
        }

        NodeList receiverChilds = receiverNode.getChildNodes();
        String receiverAccountNumber = null;

        for(int i = 0; i < receiverChilds.getLength();i++){
            if(receiverChilds.item(i).getNodeType() != Node.ELEMENT_NODE){
                continue;
            }

            if(receiverChilds.item(i).getNodeName().equals("ReceiverAccountNumber")){
                receiverAccountNumber = receiverChilds.item(i).getTextContent(); // номер счёта получателя
                list.add(receiverAccountNumber);
            }
        }

        NodeList transferChilds = transferNode.getChildNodes();
        String sumTransfer = null;

        for(int i = 0 ; i  < transferChilds.getLength(); i++){
            if(transferChilds.item(i).getNodeType() != Node.ELEMENT_NODE){
                continue;
            }

            if(transferChilds.item(i).getNodeName().equals("SUM")){
                sumTransfer = transferChilds.item(i).getTextContent(); //сумма операции
                list.add(sumTransfer);
            }
        }
        return list;
    }
}
