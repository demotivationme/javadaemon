package mainabstract;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

/**
 * Abstract model for tasks
 */
public abstract class AbstractTask {
    private String name;
    /**
     * Get task name
     * @return String name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Set task name
     * @param name
     */
    public void setName(String name) {
       this.name = name;
    }
    public abstract void init();

}
