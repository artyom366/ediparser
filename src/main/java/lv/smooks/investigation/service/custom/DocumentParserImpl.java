package lv.smooks.investigation.service.custom;

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
    public void parseDocument(final String filePath) throws IOException, SAXException {

        final byte[] messageIn = StreamUtils.readStream(new FileInputStream(filePath));
        System.out.println(new String(messageIn));

        final Smooks smooks = new Smooks("smooks-config.xml");
        final ExecutionContext executionContext = smooks.createExecutionContext();

        final JavaResult javaResult = new JavaResult();
        smooks.filterSource(executionContext, new StreamSource(new ByteArrayInputStream(messageIn)), javaResult);

        System.out.println(javaResult.toString());
    }
}
