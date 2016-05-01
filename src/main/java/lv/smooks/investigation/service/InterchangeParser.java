package lv.smooks.investigation.service;


import org.xml.sax.SAXException;

import java.io.IOException;

public interface InterchangeParser {
    void parseInterchange() throws IOException, SAXException;
}
