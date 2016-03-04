package zs.com.lbt.app.converterfactory;

import com.squareup.okhttp.ResponseBody;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import retrofit.Converter;

/**
 * Created by cq on 2015/12/11.
 */
public  final class StringResponseBodyConverter implements Converter<ResponseBody, String> {
    @Override
    public String convert(ResponseBody value) throws IOException {
        InputStream reader = null;
        try {
            reader = value.byteStream();
            ByteArrayOutputStream writer = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024 * 2];
            int size = -1;
            while ((size = reader.read(buffer)) > 0) {
                writer.write(buffer, 0, size);
            }
            String result = new String(writer.toByteArray());
            return result;
        } finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
