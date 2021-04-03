package server;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunServer {
    public static void main(String[] args){
       Monitor monitor = new Monitor();
       Server server = new Server(monitor);
    }
}
