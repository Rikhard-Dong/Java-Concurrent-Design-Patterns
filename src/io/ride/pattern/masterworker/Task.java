package io.ride.pattern.masterworker;

/**
 * @author 董凌浩
 * @Date: 2019/5/15 11:21
 */
public class Task {

    private long id;
    private String name;

    public Task(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
