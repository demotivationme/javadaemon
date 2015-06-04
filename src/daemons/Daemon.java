package daemons;

import mainabstract.AbstractTask;

/**
 * Created by demo on 20.05.15.
 */
public class Daemon extends AbstractTask {
    public Daemon() {

    }
    @Override
    public void init() {
        System.out.println("FROM DAEMON " + this.getName());
    }

   public static void ss(){
       System.out.println("SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSss");
    }
}