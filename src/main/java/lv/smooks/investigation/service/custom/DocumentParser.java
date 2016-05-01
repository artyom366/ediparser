package lv.smooks.investigation.service.custom;

import org.xml.sax.SAXException;

import java.io.IOException;

public interface DocumentParser {
    void parseDocument(String filePath) throws IOException, SAXException;
}
