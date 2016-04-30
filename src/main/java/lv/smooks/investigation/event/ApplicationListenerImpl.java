package lv.smooks.investigation.event;

import lv.smooks.investigation.service.FileAlterationListenerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class ApplicationListenerImpl implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private FileAlterationListenerImpl fileAlterationListener;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextStartedEvent) {
        fileAlterationListener.observe();
    }
}
