import com.sun.net.httpserver.HttpServer;
import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import java.io.IOException;
import java.net.URI;

public class Main {

    public static void main(String[] args) {

        System.out.println("Loading REST service...");
        ResourceConfig rc = new ResourceConfig().packages("fh.technikum");
        HttpServer server = JdkHttpServerFactory.createHttpServer(URI.create("http://localhost:8080/"),rc);
        System.out.println("REST service loaded");

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        server.stop(0);
        System.out.println("REST service stopped");

    }

}
