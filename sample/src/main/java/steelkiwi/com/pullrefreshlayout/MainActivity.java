package steelkiwi.com.pullrefreshlayout;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import steelkiwi.com.library.view.RefreshContainer;
import steelkiwi.com.pullrefreshlayout.rest.RestService;
import steelkiwi.com.pullrefreshlayout.rest.dto.PixabayResponse;

public class MainActivity extends AppCompatActivity {

    private TestAdapter adapter;
    private RefreshContainer refreshContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        refreshContainer = (RefreshContainer) findViewById(R.id.refreshContainer);

        RecyclerView recycler = (RecyclerView) findViewById(R.id.recycler);
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        adapter = new TestAdapter(this);
        recycler.setLayoutManager(manager);
        recycler.setAdapter(adapter);
        getImages();

        refreshContainer.setListener(new RefreshContainer.OnRefreshListener() {

            @Override
            public void onRefresh() {
                updateImages();
            }
        });
    }

    private void getImages() {
        RestService.createRestService()
                .getImages("5070557-61ad97e52a18d63d0ae824fa7")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PixabayResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(PixabayResponse pixabayResponse) {
                        adapter.setContent(pixabayResponse.getHits());
                    }
                });
    }

    private void updateImages() {
        RestService.createRestService()
                .getImages(getString(R.string.key))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PixabayResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(PixabayResponse pixabayResponse) {
//                        adapter.setContent(pixabayResponse.getHits());
                        refreshContainer.finishRefreshing();
                    }
                });
    }
}
