import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.net.InetSocketAddress;

public class JettyServer {
  private Server server = null;

  public void start() throws Exception {
    if (server != null) {
      throw new IllegalStateException();
    }
    server = new Server(new InetSocketAddress("localhost", 5056));

    ServletContextHandler ctx = new ServletContextHandler(ServletContextHandler.SESSIONS);
    ctx.setContextPath("/test");
    server.setHandler(ctx);

    ServletHolder jerseyServlet = ctx.addServlet(ServletContainer.class, "/*");
    jerseyServlet.setInitOrder(0);
    jerseyServlet.setInitParameter("jersey.config.server.provider.classnames", "JettyServer$Foo");

    server.start();
    Thread.sleep(1000 * 60 * 1);
    stop();
    System.out.println("hello");
  }

  public void stop() throws Exception {
    if (server == null) {
      throw new IllegalStateException();
    }
    server.stop();
    server.destroy();
    server.join();
  }

  @Path("/foo")
  public static class Foo {
    @GET
    @Path("/")

    @Produces({ "application/json" })
    public Response getResources() {
      return Response.ok("hello world\n").build();
    }
  }

  // curl -X GET http://localhost:5056/test/foo
  public static void main(String[] args) throws Exception {
    new JettyServer().start();
  }
}
