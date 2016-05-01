package lv.smooks.investigation.service.d98a;


import org.xml.sax.SAXException;

import java.io.IOException;

public interface D98AInterchangeParser {
    void parseInterchange(String filePath) throws IOException, SAXException;
}
