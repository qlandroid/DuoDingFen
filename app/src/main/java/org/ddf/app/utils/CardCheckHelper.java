package org.ddf.app.utils;

import com.zhy.http.okhttp.OkHttpUtils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;


/**
 * 描述：身份正验证
 * 邮箱 email:strive_bug@yeah.net
 * 创建时间 2018/6/20
 *
 * @author ql
 */

public class CardCheckHelper {
    public static final String UPLOAD_URL = "https://api.faceid.com/faceid/v1/ocridcard";
    public static final String API_KEY = "YKKi9DLDQyTDv6ASGZw9--ibzXT0YXen";
    public static final String API_SECRET = "Ub6FhkWrLbAs5lbwpYK1tDOKUxrGxc2I";

    public static final String MULTIPART_FORM_DATA = "image/jpg";       // 指明要上传的文件格式

    public static void okHttpUpload(String path, final UploadCallback callback) {
        File file = new File(path);             // 需要上传的文件
        RequestBody requestFile =               // 根据文件格式封装文件
                RequestBody.create(MediaType.parse(MULTIPART_FORM_DATA), file);

        // 初始化请求体对象，设置Content-Type以及文件数据流
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)            // multipart/form-data
                .addFormDataPart("image", file.getName(), requestFile)
                .addFormDataPart("api_key", API_KEY)
                .addFormDataPart("api_secret", API_SECRET)
                .build();

        // 封装OkHttp请求对象，初始化请求参数
        Request request = new Request.Builder()
                .url(UPLOAD_URL)                // 上传url地址
                .post(requestBody)              // post请求体
                .build();

        final okhttp3.OkHttpClient.Builder httpBuilder = new OkHttpClient.Builder();
        OkHttpClient okHttpClient = httpBuilder
                .connectTimeout(100, TimeUnit.SECONDS)          // 设置请求超时时间
                .writeTimeout(150, TimeUnit.SECONDS)
                .build();
        // 发起异步网络请求
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(Call call, okhttp3.Response response) throws IOException {
                if (callback != null) {
                    callback.onResponse(call, response);
                }
            }

            @Override
            public void onFailure(Call call, IOException e) {
                if (callback != null) {
                    callback.onFailure(call, e);
                }
            }
        });
    }


    public static interface UploadCallback {
        void onResponse(Call call, okhttp3.Response response);

        void onFailure(Call call, IOException e);
    }
}
