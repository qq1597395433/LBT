package zs.com.lbt.customerview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import zs.com.lbt.R;

/**
 * Created by cq on 2016/2/19.
 */
public class ClearFocusRecyclerView extends RecyclerView{
    private Context context;
    public ClearFocusRecyclerView(Context context) {
        super(context);
        this.context=context;
    }

    public ClearFocusRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
    }

    public ClearFocusRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context=context;
    }

    @Override
    public boolean dispatchKeyEventPreIme(KeyEvent event) {
        if (context != null) {
            InputMethodManager imm = (InputMethodManager) context
                    .getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm.isActive() && event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
                for (int i = 0; i < getChildCount(); i++) {
                    View view = getChildAt(i);
                    EditText editText1 = (EditText) view
                            .findViewById(R.id.edt);
                    editText1.clearFocus();
                }
            }
        }
        return super.dispatchKeyEventPreIme(event);
    }
}
