package com.example.http;

import android.util.Log;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.schedulers.Schedulers;

public class RetrofitBuilder {

    public static OkHttpClient client;

    public String baseUrl;

    private static final RxJavaCallAdapterFactory rxJava =
            RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io());


    public static final Gson defGson = new GsonBuilder()
            .setExclusionStrategies(new ExclusionStrategy[]{new ExclusionStrategy() {
                public boolean shouldSkipField(FieldAttributes fieldAttributes) {
                    Expose expose = (Expose)fieldAttributes.getAnnotation(Expose.class);
                    return expose != null;
                }

                public boolean shouldSkipClass(Class<?> aClass) {
                    return false;
                }
            }}).create();

    public RetrofitBuilder(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public <T> T build(Class<? extends T> serviceClass) {
        if (client == null) {
            synchronized (RetrofitBuilder.class) {
                if (client == null) {
                    client = newClient();
                    OkHttpClient.Builder builder = client.newBuilder();
                    // // builder.sslSocketFactory(sslSocketFactory, trustManager);  添加ssl
                    client = builder.hostnameVerifier(new NullHostnameVerifier()).build();
                }
            }
        }
        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(defGson))
                .addCallAdapterFactory(rxJava)
                .build();
        return retrofit.create(serviceClass);
    }

    private static OkHttpClient newClient () {
        OkHttpClient client = new OkHttpClient();
        return client.newBuilder()
                // .dns(SmartDns.Instance)  添加dns的地方
                .addNetworkInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                        HttpUrl url = request.url();
                        Socket socket = chain.connection().socket();
                        InetAddress address = socket.getInetAddress();
                        Response response = chain.proceed(request);

                        return response;
                    }
                })
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Response response = null;
                        response = chain.proceed(chain.request());
                        Log.i("AAAAA1",new Gson().toJson(response.body()));
                        return response;
                    }
                })
                .connectTimeout(15L, TimeUnit.SECONDS)
                .readTimeout(30L, TimeUnit.SECONDS)
                .writeTimeout(30L, TimeUnit.SECONDS)
                .build();
    }

    private static class NullHostnameVerifier implements HostnameVerifier {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            //可以添加host的一些判断
            return true;
        }
    }
}
