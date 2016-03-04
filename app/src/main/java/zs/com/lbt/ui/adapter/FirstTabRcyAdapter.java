package zs.com.lbt.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.socks.library.KLog;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import zs.com.lbt.R;
import zs.com.lbt.bean.CeShiBean;

/**
 * Created by cq on 2016/2/3.
 */
public class FirstTabRcyAdapter extends RecyclerView.Adapter<FirstTabRcyAdapter.ViewHolder> {
    private Context context;
    private List<CeShiBean> datas;

    public FirstTabRcyAdapter(Context context, List<CeShiBean> datas) {
        this.context = context;
        this.datas = datas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.adapter_first_tab_rcy, parent, false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.edt.setText(datas.get(position).getStr());
        holder.tv.setText(datas.get(position).getStr());

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.edt)
        EditText edt;
        @Bind(R.id.tv)
        TextView tv;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
