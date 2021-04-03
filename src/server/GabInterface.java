package server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GabInterface extends JFrame {

    public JPanel loginPanel;
    public JPanel operationPanel;
    public JPanel numberPanel;
    public JPanel disconnectPanel;
    public JButton button0;
    public JButton button7;
    public JButton button9;
    public JButton button3;
    public JButton button5;
    public JButton button2;
    public JButton button4;
    public JButton button6;
    public JButton button8;
    public JButton button1;
    public JButton disconnectButton;
    public JTextField firstNameField;
    public JTextField cardNumberField;
    public JButton connectButton;
    public JLabel balance;
    public JTextField valueField;
    public JButton addButton;
    public JButton cashOutButton;
    private Container container;
    private GridLayout loginGridLayout;
    private GridLayout blanceGridLayout;
    private GridLayout inputGridLayout;
    private GridLayout desconnectGridLayout;
    private GridLayout gridLayout;
    public int height = 700;
    public int width = 400;
    public String operation = "non";
    public boolean loginVisible = true;
    public boolean balanceVisible = false;
    public boolean numberVisible = false;
    public GabInterface(){
        super("GAB Client");
        loginGridLayout = new GridLayout( 6, 0, 5, 5 );
        blanceGridLayout = new GridLayout( 6, 0, 5, 5 );
        inputGridLayout = new GridLayout( 5, 3, 5, 5 );
        desconnectGridLayout = new GridLayout(1,0,5,5);
        gridLayout = new GridLayout(4,0,5,5);
        GridLayout Layout1 = new GridLayout(1,0,5,5);
        GridLayout Layout2 = new GridLayout(1,0,5,5);
        GridLayout Layout3 = new GridLayout(1,0,5,5);
        JPanel panel1 = new JPanel();
        panel1.setLayout(Layout1);
        JPanel panel2 = new JPanel();
        panel1.setLayout(Layout2);
        JPanel panel3 = new JPanel();
        panel1.setLayout(Layout3);
        FlowLayout flowLayout = new FlowLayout();
        container = getContentPane();
        this.setLayout(gridLayout);
        flowLayout.setAlignment( FlowLayout.CENTER );
        flowLayout.layoutContainer( container );
        loginPanel = new JPanel();
        loginPanel.setLayout(loginGridLayout);
        operationPanel = new JPanel();
        operationPanel.setLayout(blanceGridLayout);
        numberPanel = new JPanel();
        numberPanel.setLayout(inputGridLayout);
        disconnectPanel = new JPanel();
        disconnectPanel.setLayout(desconnectGridLayout);
        button0 = new JButton("0");
        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");
        button7 = new JButton("7");
        button8 = new JButton("8");
        button9 = new JButton("9");
        connectButton = new JButton("Connect");
        disconnectButton = new JButton("Disconnect");
        addButton = new JButton("Add");
        cashOutButton = new JButton("Remove");
        firstNameField = new JTextField(50);
        cardNumberField = new JTextField(50);
        valueField = new JTextField(50);
        balance = new JLabel("12235DA");
        loginPanel.add(firstNameField);
        loginPanel.add(cardNumberField);
        loginPanel.add(connectButton);
        loginPanel.add(new JLabel(""));
        loginPanel.add(new JLabel(""));
        loginPanel.add(new JLabel(""));
        operationPanel.add(balance);
        operationPanel.add(valueField);
        operationPanel.add(new JLabel(""));
        operationPanel.add(new JLabel(""));
        operationPanel.add(new JLabel(""));
        operationPanel.add(new JLabel(""));
        numberPanel.add(button1);
        numberPanel.add(button2);
        numberPanel.add(button3);
        numberPanel.add(button4);
        numberPanel.add(button5);
        numberPanel.add(button6);
        numberPanel.add(button7);
        numberPanel.add(button8);
        numberPanel.add(button9);
        numberPanel.add(addButton);
        numberPanel.add(button0);
        numberPanel.add(cashOutButton);
        numberPanel.add(new JLabel(""));
        numberPanel.add(disconnectButton);
        numberPanel.add(new JLabel(""));
        add(loginPanel);
        add(operationPanel);
        add(numberPanel);
        operationPanel.setVisible(balanceVisible);
        numberPanel.setVisible(numberVisible);
        this.setSize(width,height);
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        this.setVisible( true );
        button0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                valueField.setText(valueField.getText()+"0");
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                valueField.setText(valueField.getText()+"1");
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                valueField.setText(valueField.getText()+"2");
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                valueField.setText(valueField.getText()+"3");
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                valueField.setText(valueField.getText()+"4");
            }
        });
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                valueField.setText(valueField.getText()+"5");
            }
        });
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                valueField.setText(valueField.getText()+"6");
            }
        });
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                valueField.setText(valueField.getText()+"7");
            }
        });
        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                valueField.setText(valueField.getText()+"8");
            }
        });
        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                valueField.setText(valueField.getText()+"9");
            }
        });
        disconnectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                    operation = "logout";
            }
        });
        connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                    operation = "login";
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                    operation = "add";
            }
        });
        cashOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                    operation = "remove";
            }
        });

    }
}
