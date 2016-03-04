package zs.com.lbt.entry;

import java.util.List;

/**
 * Created by cq on 2016/2/1.
 */
public class ReturnValue<T> {
    private String retcode;
    private List<T> list;


    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public String getRetcode() {
        return retcode;
    }

    public void setRetcode(String retcode) {
        this.retcode = retcode;
    }

    @Override
    public String toString() {
        return "ReturnValue{" +
                "list=" + list +
                ", retcode='" + retcode + '\'' +
                '}';
    }
}
