package server;

public interface Buffer {
    public int[] accessAccount(int id,String thread)throws InterruptedException;
    public int[] releasAccount(int id,String thread)throws InterruptedException;
}
