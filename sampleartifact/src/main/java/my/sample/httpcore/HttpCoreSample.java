package my.sample.httpcore;

import org.apache.http.*;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.DefaultBHttpServerConnection;
import org.apache.http.protocol.*;

import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Locale;

/**
 * Created by ltian on 5/14/2017.
 */
public class HttpCoreSample {
    public static class WebServiceHandler implements HttpRequestHandler {
        public void handle(final HttpRequest request,
                           final HttpResponse response, final HttpContext context)
                throws HttpException, IOException {

            String method = request.getRequestLine().getMethod()
                    .toUpperCase(Locale.ENGLISH);
            //get uri
            String target = request.getRequestLine().getUri();
            if (method.equals("GET") ) {
                if(!target.equalsIgnoreCase("/")) {
                    response.setStatusCode(HttpStatus.SC_OK);
                    File file = new File("C:\\Users\\ltian\\IdeaProjects\\MyScalaTest\\resources\\app.ico");
                    FileEntity fileEntity = new FileEntity(
                            file);
                    request.addHeader("Content-Type", ContentType.DEFAULT_BINARY.getMimeType());
                    response.setEntity(fileEntity);
                }
                response.setStatusCode(HttpStatus.SC_OK);
                int id = (int)context.getAttribute("session-id");
                context.setAttribute("session-id", ++id);
                StringEntity entity = new StringEntity("<xml><method>get</method><url>" + target + String.valueOf(id) + "</url></xml>");
                FileEntity fileEntity = new FileEntity(new File("C:\\Users\\ltian\\IdeaProjects\\MyScalaTest\\resources\\content"));
//                response.addHeader(ContentType.APPLICATION_XML);
                response.setHeader("Content-Type", ContentType.APPLICATION_XML.getMimeType());
                response.setEntity(entity);
            }
            else if (method.equals("POST") )
            {
                response.setStatusCode(HttpStatus.SC_OK);
                StringEntity entity = new StringEntity("<xml><method>post</method><url>" + target + "</url></xml>");
                response.setEntity(entity);
            }
            else
            {
                throw new MethodNotSupportedException(method
                        + " method not supported");
            }
        }
    }

    public static class WorkerThread extends Thread {
        private final HttpService httpservice;
        private final HttpServerConnection conn;
        private final HttpContext context;

        public WorkerThread(final HttpService httpservice, final HttpServerConnection conn, final HttpContext context) {
            super();
            this.httpservice = httpservice;
            this.conn = conn;
            this.context = context;
        }

        @Override
        public void run() {
            System.out.println("New connection thread");
            try {
                while (!Thread.interrupted() && this.conn.isOpen()) {
                    this.httpservice.handleRequest(this.conn, context);
                }
            } catch (Exception e) {

            }
            finally {
                try {
                    this.conn.shutdown();
                } catch (IOException ignore) {
                }
            }
        }
    }

    public static class MyHttpServerThread extends Thread {
        private final ServerSocket serversocket;
        private final HttpService httpService;
        private final HttpContext httpContext;

        public MyHttpServerThread(int port) throws Exception {
            serversocket = new ServerSocket(port);
            HttpProcessor httpproc = new ImmutableHttpProcessor(new HttpResponseInterceptor[] { new ResponseDate(), new ResponseServer(), new ResponseContent(), new ResponseConnControl() });
            UriHttpRequestHandlerMapper register = new UriHttpRequestHandlerMapper();
            register.register("/", new WebServiceHandler());  //WebServiceHandler用来处理webservice请求。
            httpService = new HttpService(httpproc, register);
            httpContext = HttpCoreContext.create();
            httpContext.setAttribute("session-id", 1);
        }

        @Override
        public void run() {
            System.out.println("Listening on port "
                    + this.serversocket.getLocalPort());
            System.out.println("Thread.interrupted = " + Thread.interrupted());
            while (!Thread.interrupted()) {
                try {
                    // Set up HTTP connection
                    Socket socket = this.serversocket.accept();
                    DefaultBHttpServerConnection conn = new DefaultBHttpServerConnection(8 * 1024);
//                    DefaultHttpServerConnection conn = new DefaultHttpServerConnection();
                    System.out.println("Incoming connection from "
                            + socket.getInetAddress());
                    //conn.bind(socket, this.params);
                    conn.bind(socket);
                    // Start worker thread
                    Thread t = new WorkerThread(this.httpService, conn, httpContext);
                    t.setDaemon(true);
                    t.start();
                } catch (InterruptedIOException ex) {
                    break;
                } catch (IOException e) {
                    System.err
                            .println("I/O error initialising connection thread: "
                                    + e.getMessage());
                    break;
                }
            }
        }
    }
}
