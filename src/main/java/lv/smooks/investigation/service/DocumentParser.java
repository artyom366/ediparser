package lv.smooks.investigation.service;

import org.xml.sax.SAXException;

import java.io.IOException;

public interface DocumentParser {
    void parseDocument() throws IOException, SAXException;
}
