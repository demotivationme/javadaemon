package daemons;

import mainabstract.AbstractTask;

/**
 * Created by demo on 20.05.15.
 */
public class DaemonSecond extends AbstractTask {
    public DaemonSecond() {

    }
    @Override
    public void init() {
        System.out.println("FROM DAEMON " + this.getName());
    }
}