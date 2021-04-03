package server;

import java.util.Random;

public class ThreadTest implements Runnable{
    public Monitor monitor ;
    Random rand = new Random();
    public String name;
    public ThreadTest(Monitor monitor,String name){
        this.monitor = monitor;
        this.name = name;
    }
    @Override
    public void run() {
        while(true){
            try {
                int id = 1+rand.nextInt(3);
                System.out.println("id == "+id);
                int[] indexId = monitor.accessAccount(id,name);
                Account account = null;
                int index = -1;
                for(Account acc : Monitor.accounts){
                    if(id == acc.getId()){
                        account = acc;
                        index++;
                        break;
                    }
                }
                int substractOrAdd = 1 + rand.nextInt(2);
                switch(substractOrAdd) {
                    case 1:
                        double substract = 1+rand.nextInt(5000);
                        if ((account.getDebit() - substract) > 0){
                            account.setDebit(account.getDebit() - substract);
                        }
                        break;
                    case 2:
                        double add = 1+rand.nextInt(5000);
                        account.setDebit(account.getDebit()+add);
                }
                monitor.releasAccount(account.getId(),name);
                Thread.sleep(1+rand.nextInt(2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
