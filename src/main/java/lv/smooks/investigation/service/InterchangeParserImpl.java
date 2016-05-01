package lv.smooks.investigation.service;


import org.milyn.GenericReaderConfigurator;
import org.milyn.edi.unedifact.d98a.D98AInterchangeFactory;
import org.milyn.edi.unedifact.d98a.DESADV.Desadv;
import org.milyn.edi.unedifact.d98a.INSDES.Insdes;
import org.milyn.edisax.unedifact.UNEdifactInterchangeParser;
import org.milyn.smooks.edi.unedifact.model.UNEdifactInterchange;
import org.milyn.smooks.edi.unedifact.model.r41.UNEdifactInterchange41;
import org.milyn.smooks.edi.unedifact.model.r41.UNEdifactMessage41;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.transform.Result;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
public class InterchangeParserImpl implements InterchangeParser {

    @Override
    public void parseInterchange() throws IOException, SAXException {


        D98AInterchangeFactory factory = D98AInterchangeFactory.getInstance();
        factory.addConfigurations(new FileInputStream("smooks-resources.xml"));

        InputStream inputStream = new FileInputStream("C:\\edi\\desadv.txt");
        UNEdifactInterchange interchange = factory.fromUNEdifact(inputStream);


        if (interchange instanceof UNEdifactInterchange41) {
            UNEdifactInterchange41 interchange41 = (UNEdifactInterchange41) interchange;

            System.out.println(interchange41.getInterchangeHeader().getDate());
            System.out.println(interchange41.getInterchangeHeader().getSender().getId());
            System.out.println(interchange41.getInterchangeHeader().getRecipient().getId());

            for (UNEdifactMessage41 message41 : interchange41.getMessages()) {

                message41.getMessageHeader().getMessageIdentifier().getAssociationAssignedCode();

                Object type = message41.getMessage();
                if (type instanceof Insdes) {
                    Insdes purchaseOrder = (Insdes) type;
                    System.out.println("It's a purchase order");
                    //todo call po service

                } else if (type instanceof Desadv) {
                    Desadv customerOrder = (Desadv) type;
                    System.out.println("It's a customer order");
                    //todo call co service
                }
            }
        }
    }
}
