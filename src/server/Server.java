package server;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server extends JFrame {
    public Monitor monitor;
    public JButton addGab;
    ExecutorService application = Executors.newCachedThreadPool();
    public ArrayList<ClientHandler> clientHandlers = new ArrayList<>();
    public Server(Monitor monitor){
        super("server");
        this.monitor = monitor;
        addGab = new JButton("Start new Client");
        this.add(addGab);
        this.setSize(100,100);
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        this.setVisible( true );
        addGab.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ClientHandler clientHandler = new ClientHandler(monitor);
                clientHandlers.add(clientHandler);
                clientHandler.start();
                //application.execute(clientHandler);
            }
        });
        //application.shutdown();
    }
}
