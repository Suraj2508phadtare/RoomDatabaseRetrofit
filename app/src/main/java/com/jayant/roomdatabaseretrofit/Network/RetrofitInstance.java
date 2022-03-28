package com.jayant.roomdatabaseretrofit.Network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance
{
        private static Retrofit retrofit;

        public static Retrofit getRetroClient() {

                if(retrofit == null ) {

                        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
                        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

                        OkHttpClient client = new OkHttpClient.Builder()
                                .connectTimeout(100, TimeUnit.SECONDS)
                                .readTimeout(100, TimeUnit.SECONDS)
                                .writeTimeout(100, TimeUnit.SECONDS)
                                .addInterceptor(interceptor).build();
                        //client.conn

                        Gson gson = new GsonBuilder()
                                .setLenient()
                                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                                .create();

                        retrofit = new Retrofit.Builder()
                                .client(client)
                                .addConverterFactory(GsonConverterFactory.create(gson))
                                .baseUrl(Url.URL_DATA)
                                .build();


                    /*retrofit = new Retrofit.Builder()
                            .baseUrl(BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();*/
                }
                return retrofit;
        }
}

/*public class Retrofit {
    retrofit2.Retrofit retrofit=new retrofit2.Retrofit.Builder()
            .baseUrl(Url.URL_DATA)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    public Api api=retrofit.create(Api.class);
}*/
