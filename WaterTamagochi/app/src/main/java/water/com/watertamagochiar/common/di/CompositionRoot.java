package water.com.watertamagochiar.common.di;

import android.content.Context;

import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import water.com.watertamagochiar.database.AppDatabase;
import water.com.watertamagochiar.database.SharedPreferencesHelper;

public class CompositionRoot {

    private Retrofit mRetrofit;
    private SharedPreferencesHelper mSharedPreferencesHelper;

    public SharedPreferencesHelper getSharedPreferencesHelper(Context context) {
        if(mSharedPreferencesHelper == null) {
            mSharedPreferencesHelper = new SharedPreferencesHelper(context);
        }
        return mSharedPreferencesHelper;
    }

//    private Retrofit getRetrofit(Context context) {
//        if(mRetrofit == null || hasUrlChanged(context)) {
//            mRetrofit = new Retrofit.Builder()
//                    .client(getClient())
//                    .baseUrl(getSharedPreferencesHelper(context).getApiBaseUrl())
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build();
//        }
//        return mRetrofit;
//    }

    private AppDatabase getAppDatabase(Context context) {
        return AppDatabase.getInstance(context.getApplicationContext());
    }

    private OkHttpClient getClient(){
        return new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .addInterceptor(getLoggingInterceptor())
                .build();
    }

    private Interceptor getLoggingInterceptor(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }

}
