package zs.com.lbt.app;

import java.util.ArrayList;
import java.util.List;

import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;
import rx.Observable;
import zs.com.lbt.app.converterfactory.StringConverterFactory;
import zs.com.lbt.entry.ReturnValue;

/**
 * Created by cq on 2016/2/1.
 */
public class ApiManger {
    private ApiService apiService;
    private Retrofit retrofit;
    private static ApiManger apiManger;

    private ApiManger() {
    }

    public <T> List<T> processReturnValue(ReturnValue<T> returnValue) {
        if (returnValue.getRetcode().equals(Constants.RETCODE_SUCCESS)) {
            List<T> list = returnValue.getList();
            if (list == null) {
                return new ArrayList<T>();
            }
            return list;
        }
        // 这里可以改成 返回null    异常即可捕捉
        return null;
    }


    public static ApiManger getInstance(){
        if(apiManger==null){
            synchronized (ApiManger.class){
                if(apiManger==null){
                    apiManger=new ApiManger();
                }
            }
        }
        return apiManger;
    }

    public ApiService apiService(){
        if(retrofit==null){
            retrofit=new Retrofit.Builder().baseUrl(Constants_api.BASE_URL)
                    .addConverterFactory(StringConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
        }
        if(apiService==null){
            apiService=retrofit.create(ApiService.class);
        }
        return apiService;
    }


    public interface ApiService {

    }
}
