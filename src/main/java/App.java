import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    private Client client;
    private EventLogger eventLogger;
    private Event event;

    public App(Client client, EventLogger eventLogger, Event event) {
        this.client = client;
        this.eventLogger = eventLogger;
        this.event = event;
    }

    public App() {
    }

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        App app = context.getBean(App.class);
        App app1 = context.getBean(App.class);
        app.logEvent("pidor");
        Thread.sleep(5000);
        app1.logEvent("pizda");

    }

    private void logEvent(String msg) {
        event.setMsg(msg + " " + client.getFullName());
        eventLogger.logEvent(event);
    }
}
