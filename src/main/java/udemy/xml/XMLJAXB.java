package udemy.xml;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;

import java.io.File;
import java.io.IOException;

public class XMLJAXB {
    public static void main(String[] args) {
        //making mapper to understand javax.xml.bind.annotation.
        XmlMapper mapper = new XmlMapper();
        mapper.registerModule(new JaxbAnnotationModule());

        try {

            System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(new XML()));
            try {
                XML xml = new XML();
                xml.setProperty1("Dina");
                xml.setProperty2("Lugu");
                xml.setAttribute1("Attr1");
                mapper.writerWithDefaultPrettyPrinter().writeValue(new File("C:\\projects\\json\\hfile.xml"), xml);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
