package util;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * 作者：created by chulei on 2021/5/24 11:02
 * 邮箱：clshijie168@163.com
 */
public class HttpUtil {
    public static void sendOkHttpRequest(String address, okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(address).build();
        client.newCall(request).enqueue(callback);
    }
}
