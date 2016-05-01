package lv.smooks.investigation.service.d96a;

import org.xml.sax.SAXException;

import java.io.IOException;

public interface D96AInterchangeParser {
    void parseInterchange(String filePath) throws IOException, SAXException;
}
