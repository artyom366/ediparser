package lv.smooks.investigation.service;


import lv.smooks.investigation.service.custom.DocumentParser;
import lv.smooks.investigation.service.d96a.D96AInterchangeParser;
import lv.smooks.investigation.service.d98a.D98AInterchangeParser;
import org.apache.commons.io.monitor.FileAlterationListener;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

@Service
public class FileAlterationListenerImpl  {

    @Autowired
    private DocumentParser documentParser;

    @Autowired
    private D98AInterchangeParser d98AInterchangeParser;

    @Autowired
    private D96AInterchangeParser d96AInterchangeParser;

    private final static String FILE_PATH = "C:\\edi";
    private static final long POOLING_INTERVAL = 5 * 1000;

    public void observe() {

        final FileAlterationObserver fileAlterationObserver = new FileAlterationObserver(new File(FILE_PATH));

        fileAlterationObserver.addListener(new FileAlterationListener() {

            @Override
            public void onStart(FileAlterationObserver fileAlterationObserver) {

            }

            @Override
            public void onDirectoryCreate(File file) {

            }

            @Override
            public void onDirectoryChange(File file) {

            }

            @Override
            public void onDirectoryDelete(File file) {

            }

            @Override
            public void onFileCreate(final File file) {

                try {
                    //documentParser.parseDocument(file.getAbsolutePath());
                    //d98AInterchangeParser.parseInterchange(file.getAbsolutePath());
                    d96AInterchangeParser.parseInterchange(file.getAbsolutePath());

                } catch (IOException | SAXException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFileChange(File file) {

            }

            @Override
            public void onFileDelete(File file) {

            }

            @Override
            public void onStop(FileAlterationObserver fileAlterationObserver) {

            }
        });

        final FileAlterationMonitor fileAlterationMonitor = new FileAlterationMonitor(POOLING_INTERVAL);
        fileAlterationMonitor.addObserver(fileAlterationObserver);

        try {
            fileAlterationMonitor.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
