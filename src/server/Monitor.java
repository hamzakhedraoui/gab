package server;

import java.util.ArrayList;
import java.util.Random;

public class Monitor implements Buffer {

    public final static ArrayList<Account> accounts = new ArrayList<>();
    public Monitor(){
        accounts.add(new Account(1,"user1","user11",3000,0,"1111111111"));
        accounts.add(new Account(2,"user2","user22",3000,0,"2222222222"));
        accounts.add(new Account(3,"user3","user33",3000,0,"3333333333"));
    }
    @Override
    public synchronized int[] accessAccount(int id,String thread) throws InterruptedException {
        Account account = null;
        int index = -1;
        for(Account acc : accounts){
            if(id == acc.getId()){
                account = acc;
                index++;
                break;
            }
        }
        while(account != null && account.getLock()==1) {
            System.out.println("waiting to access account with the id : "+id+" from thread : "+thread);
            wait();
        }
        System.out.println("Access account with the id : "+id+" from thread : "+thread);
        account.setLock(1);
        //displayState( "Car enter in place :" + index );
        notifyAll();
        int[] ret = {index,id};
        return ret;
    }
    @Override
    public synchronized int[] releasAccount(int id,String thread) throws InterruptedException {
        Account account = null;
        int index = -1;
        for(Account acc : accounts){
            if(id == acc.getId()){
                account = acc;
                index++;
                break;
            }
        }
        while(account != null && account.getLock()==0) {
            System.out.println("waiting to release account with the id : "+id+" from thread : "+thread);
            wait();
        }
        System.out.println("raleas account with the id : "+id+" from thread : "+thread);
        account.setLock(0);
        notifyAll();
        int[] ret = {index,id};
        return ret;
    }

}
