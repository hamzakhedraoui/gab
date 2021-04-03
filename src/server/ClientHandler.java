package server;

import server.GabInterface;

import javax.swing.*;
import java.util.ArrayList;

public class ClientHandler extends Thread{
    public GabInterface gInterface;
    public int accountId;
    public Monitor monitor;
    public ClientHandler(Monitor monitor){
        try {
            this.monitor = monitor;
            gInterface = new GabInterface();
        }catch(Exception ex){
            System.out.println("exception in ClientSocketHandler....");
        }
    }
    public void run(){

        while (true)
        {
            try {
                String operation = gInterface.operation;
                switch (operation){
                    case "login":
                        boolean status = false;
                        ArrayList<Account> accounts = Monitor.accounts;
                        System.out.println("card number : "+ gInterface.cardNumberField.getText());
                        System.out.println("first name  : "+ gInterface.firstNameField.getText());
                        for(Account account:accounts){
                            System.out.println(account);
                            if(gInterface.firstNameField.getText().equals(account.getFirstName())){
                                if(gInterface.cardNumberField.getText().equals(account.getCradeNumber())){
                                    accountId = account.getId();
                                    if(account.getLock()==0){
                                        System.out.println("lock == 0....");
                                        status = true;
                                        gInterface.balance.setText(""+account.getDebit()+ " DA");
                                        gInterface.loginVisible = false;
                                        gInterface.loginPanel.setVisible(gInterface.loginVisible);
                                        gInterface.balanceVisible = true;
                                        gInterface.operationPanel.setVisible(gInterface.balanceVisible);
                                        gInterface.numberVisible = true;
                                        gInterface.numberPanel.setVisible(gInterface.numberVisible);
                                        monitor.accessAccount(account.getId(),"");
                                        break;
                                    }else{
                                        System.out.println("lock == 1....");
                                        status = true;
                                        JOptionPane.showMessageDialog( null, "this account is locked you need to wait for the other user to finish...",
                                                "Notification", JOptionPane.PLAIN_MESSAGE );
                                        monitor.accessAccount(account.getId(),"");
                                        gInterface.balance.setText("" + account.getDebit() + " DA");
                                        gInterface.loginVisible = false;
                                        gInterface.loginPanel.setVisible(gInterface.loginVisible);
                                        gInterface.balanceVisible = true;
                                        gInterface.operationPanel.setVisible(gInterface.balanceVisible);
                                        gInterface.numberVisible = true;
                                        gInterface.numberPanel.setVisible(gInterface.numberVisible);
                                        System.out.println("unlucked...");
                                        JOptionPane.showMessageDialog( null, "account have been unlocked you're free to use it now...",
                                                "Notification", JOptionPane.PLAIN_MESSAGE );
                                        break;
                                    }
                                }
                            }
                        }
                        if (!status) {
                            JOptionPane.showMessageDialog( null, "account doesn't exist...",
                                    "Notification", JOptionPane.PLAIN_MESSAGE );
                        }
                        gInterface.operation = "non";
                        break;
                    case "logout":
                        monitor.releasAccount(accountId,"");
                        gInterface.loginVisible = true;
                        gInterface.loginPanel.setVisible(gInterface.loginVisible);
                        gInterface.balanceVisible = false;
                        gInterface.operationPanel.setVisible(gInterface.balanceVisible);
                        gInterface.numberVisible = false;
                        gInterface.numberPanel.setVisible(gInterface.numberVisible);
                        gInterface.operation = "non";
                        break;

                    case "add":
                        for(Account account: monitor.accounts){
                            if(accountId == account.getId()){
                                double add = Double.parseDouble(gInterface.valueField.getText());
                                account.setDebit(account.getDebit()+add);
                                gInterface.balance.setText(""+account.getDebit()+ " DA");
                                break;
                            }
                        }
                        gInterface.operation = "non";
                        break;
                    case "remove":
                        for(Account account: monitor.accounts){
                            if(accountId == account.getId()){
                                double substract =  Double.parseDouble(gInterface.valueField.getText());
                                if ((account.getDebit() - substract) > 0){
                                    account.setDebit(account.getDebit() - substract);
                                    gInterface.balance.setText(""+account.getDebit()+ " DA");
                                    break;
                                }else{
                                    JOptionPane.showMessageDialog( null, "you want you remove more than you have...",
                                            "Notification", JOptionPane.PLAIN_MESSAGE );
                                    gInterface.valueField.setText(""+account.getDebit());
                                }
                            }
                        }
                        gInterface.operation = "non";
                        break;
                }
                Thread.sleep(100);
            }catch(Exception ex){
                System.out.println("exception in run method in ClientSocketHandler");
            }
        }
    }
}
