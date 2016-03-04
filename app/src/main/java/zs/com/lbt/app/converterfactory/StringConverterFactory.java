package zs.com.lbt.app.converterfactory;

import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.ResponseBody;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import retrofit.Converter;

/**
 * Created by cq on 2015/12/11.
 */
public class StringConverterFactory extends Converter.Factory{

    private StringConverterFactory() {
    }
    public static StringConverterFactory create(){
        return new StringConverterFactory();
    }
    @Override
    public Converter<ResponseBody, ?> fromResponseBody(Type type, Annotation[] annotations) {
        return new StringResponseBodyConverter();
    }

}
