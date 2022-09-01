package a;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

import javax.xml.validation.Validator;

public class XMLValidation {
	public static final String PATH = "C:\\Users\\user\\eclipse-workspace\\a\\a\\";
    public static final String XML_FILE = "records1.xml";
    public static final String SCHEMA_FILE = "records.xsd";

    public static void main(String[] args) {
        XMLValidation XMLValidation = new XMLValidation();
        boolean valid = XMLValidation.validate(PATH+XML_FILE, PATH+SCHEMA_FILE);

        System.out.printf("%s validation = %b.", XML_FILE, valid);
    }

    private boolean validate(String xmlFile, String schemaFile) {
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
            Schema schema = schemaFactory.newSchema(new File(schemaFile));

            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlFile)));
            return true;
        } catch (SAXException | IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}