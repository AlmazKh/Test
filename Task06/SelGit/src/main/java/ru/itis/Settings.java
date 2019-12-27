package ru.itis;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Settings {
    public static Map<String, String> map = new HashMap<>();

    private static String baseUrl;
    private static String login;
    private static String password;

    static {
        DocumentBuilder documentBuilder = null;
        try {
            documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
//        XmlMapper xmlMapper = new XmlMapper();
//        TxtFile txtFile = xmlMapper.readValue(new File("C:\\Users\\Almaz\\Desktop\\Test\\Task05\\SelGit\\testFileData.xml"), )

        Document document = null;
        try {
            document = documentBuilder.parse("C:\\Users\\Almaz\\Desktop\\Test\\Task06\\SelGit\\settings.xml");
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
            Node root = document.getDocumentElement();
            NodeList nodes = root.getChildNodes();
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                if (!node.getNodeName().equals("#text")) {
                    map.put(node.getNodeName(), node.getTextContent());
                }
            }
    }

    public static String getValue (String key){
        return map.get(key);
    }

    public static String getBaseUrl() {
        return baseUrl;
    }

    public static String getLogin() {
        return login;
    }

    public static String getPassword() {
        return password;
    }
}


