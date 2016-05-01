package lv.smooks.investigation.service.d98a;

import org.milyn.edi.unedifact.d98a.D98AInterchangeFactory;
import org.milyn.edi.unedifact.d98a.DESADV.Desadv;
import org.milyn.edi.unedifact.d98a.INSDES.Insdes;
import org.milyn.smooks.edi.unedifact.model.UNEdifactInterchange;
import org.milyn.smooks.edi.unedifact.model.r41.UNEdifactInterchange41;
import org.milyn.smooks.edi.unedifact.model.r41.UNEdifactMessage41;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class D98AInterchangeParserImpl implements D98AInterchangeParser {

    @Override
    public void parseInterchange(final String filePath) throws IOException, SAXException {

        final D98AInterchangeFactory factory = D98AInterchangeFactory.getInstance();

        final BufferedReader reader = Files.newBufferedReader(Paths.get(filePath), Charset.forName("UTF-8"));
        final StringBuffer document = new StringBuffer();
        String line;

        while ((line = reader.readLine()) != null) {

            if (line.contains("D:96A:UN")) {
                line.replace("D:96A:UN", "D:98A:UN");
            }

            line = line.replace("\n", "").replace("\r", "");

            document.append(line);
        }

        final UNEdifactInterchange interchange = factory.fromUNEdifact(new ByteArrayInputStream(document.toString().getBytes()));

        if (interchange instanceof UNEdifactInterchange41) {
            final UNEdifactInterchange41 interchange41 = (UNEdifactInterchange41) interchange;

            for (UNEdifactMessage41 message41 : interchange41.getMessages()) {

                message41.getMessageHeader().getMessageIdentifier().getAssociationAssignedCode();

                Object type = message41.getMessage();
                if (type instanceof Insdes) {
                    final Insdes customerOrder  = (Insdes) type;
                    System.out.println("It's a purchase order");

                } else if (type instanceof Desadv) {
                    final Desadv purchaseOrder = (Desadv) type;
                    System.out.println("It's a customer order");
                }
            }
        }
    }
}
