package zs.com.lbt.util;

import android.content.Context;
import android.widget.Toast;

import rx.Subscriber;

/**
 * Created by cq on 2016/1/7.
 */
public class DefaultSubscriber<T> extends Subscriber<T>{
    private Context context;

    public DefaultSubscriber(Context context) {
        this.context = context;
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        Toast.makeText(context,e.toString(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNext(T t) {

    }
}
