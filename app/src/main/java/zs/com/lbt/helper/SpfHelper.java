package zs.com.lbt.helper;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Spf
 * Created by 右右 on 2015/4/30.
 */
public class SpfHelper {

    private SharedPreferences.Editor editor;
    private SharedPreferences sharedPreferences;


    public SpfHelper(Context context,String fileName) {
        sharedPreferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    /**
     * 清理
     */
    public void deleteAll() throws Exception {
        editor.clear();
        editor.commit();
    }

    /**
     * 删除一条数据
     */
    public void delete(String key) {
        editor.remove(key);
        editor.commit();
    }

    /**
     * 保存
     */
    public void saveData(String key, String data) {
        editor.putString(key, data);
        editor.commit();
    }

    /**
     * 保存
     */
    public void saveIntData(String key, int data) {
        editor.putInt(key, data);
        editor.commit();
    }

    /**
     * 保存 不提交
     */
    public void saveDataNoCommit(String key, String data) {
        editor.putString(key, data);
    }

    /**
     * 提交
     */
    public void commit() {
        editor.commit();
    }

    /**
     * 获取
     */
    public String getData(String key) {
        return sharedPreferences.getString(key, "");
    }

    /**
     * 获取
     */
    public int getIntData(String key) {
        return sharedPreferences.getInt(key, 0);
    }

    /**
     * 获取 带默认
     */
    public String getData(String key, String defValue) {
        return sharedPreferences.getString(key, defValue);
    }

    /**
     * 包含
     */
    public boolean contains(String key){
        return sharedPreferences.contains(key);
    }

    /**
     * Editor
     */
    public SharedPreferences.Editor getEditor() {
        return editor;
    }

}
