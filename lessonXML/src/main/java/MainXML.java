import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class MainXML {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, TransformerException {


//        //чтение документа
//        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//        DocumentBuilder builder = factory.newDocumentBuilder();
//        Document document = builder.parse(new File("lessonXML/src/main/resources/company.xml"));
//
//        Node root = document.getDocumentElement();
//        System.out.println("Корневой элемент: " + root.getNodeName());
//        read(root);


//        //создание элемента
//        DocumentBuilderFactory factory = DocumentBuilderFactory. newInstance();
//        DocumentBuilder builder = factory.newDocumentBuilder();
//        Document document = builder.newDocument();
//
//        Element root = document.createElement( "root");//создаем элемент
//        document.appendChild(root);//добавляем его к корню
//        Element company = document.createElement( "company");
//        root.appendChild(company);
//        Element equipment = document.createElement( "equipment");
//        company.appendChild(equipment);
//        Element staff = document.createElement( "staff");
//        company.appendChild(staff);
//        Element employee = document.createElement( "employee");
//        employee.setAttribute( "id", "3");
//        employee.setAttribute( "firstname", "Nikita");
//        employee.setAttribute( "lastname", "Shumskii");
//        staff.appendChild(employee);
//        Element tool = document.createElement( "tool"); //вложенный элемент
//        tool.appendChild(document.createTextNode( "123456"));
//        employee.appendChild(tool);
//
//        DOMSource domSource = new DOMSource(document); //оборачиваем в источник данных
//        StreamResult streamResult = new StreamResult( new File("lessonXML/src/main/resources/new_company.xml"));
//
//        TransformerFactory transformerFactory = TransformerFactory. newInstance();
//        Transformer transformer = transformerFactory.newTransformer();
//        transformer.transform(domSource, streamResult);


        //редактирование
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File("lessonXML/src/main/resources/company.xml"));

        NodeList nodeList = doc.getElementsByTagName("employee");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (Node.ELEMENT_NODE == node.getNodeType()) {
                Element element = (Element) node;
                if (element.getAttribute("id").equals("2")) {
                    element.getElementsByTagName("tool").item(0).setTextContent("124562");
                }
            }
        }

        DOMSource domSource = new DOMSource(doc); //оборачиваем в источник данных
        StreamResult streamResult = new StreamResult(new File("lessonXML/src/main/resources/new_create_company.xml"));

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.transform(domSource, streamResult);


    }



    private static void read(Node node) {
        NodeList nodeList = node.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node_ = nodeList.item(i);
            if (Node.ELEMENT_NODE == node_.getNodeType()) {
                System.out.println("Текущий узел: " + node_.getNodeName());
                Element element = (Element) node_;
                NamedNodeMap map = element.getAttributes();
                for (int a = 0; a < map.getLength(); a++) {
                    String attrName = map.item(a).getNodeName();
                    String attrValue = map.item(a).getNodeValue();
                    System.out.println("Атрибут: " + attrName + "; значение: " + attrValue);
                }
                read(node_);
            }
        }
    }
}
