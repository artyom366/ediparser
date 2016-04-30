package lv.smooks.investigation.service;

import org.milyn.Smooks;
import org.milyn.container.ExecutionContext;
import org.milyn.io.StreamUtils;
import org.milyn.payload.JavaResult;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;

@Component
public class DocumentParserImpl implements DocumentParser {

    @Override
    public void parseHeader() throws IOException, SAXException {

        byte[] messageIn = StreamUtils.readStream(new FileInputStream("C:\\edi\\input-message.edi"));
        System.out.println(new String(messageIn));

        Smooks smooks = new Smooks("smooks-config.xml");
        ExecutionContext executionContext = smooks.createExecutionContext();



        JavaResult javaResult = new JavaResult();

        smooks.filterSource(executionContext, new StreamSource(new ByteArrayInputStream(messageIn)), javaResult);

        int i = 0;
    }
}
