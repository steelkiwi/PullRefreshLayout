package steelkiwi.com.pullrefreshlayout;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import steelkiwi.com.library.view.RefreshContainer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RefreshContainer refreshContainer = (RefreshContainer) findViewById(R.id.refreshContainer);

        RecyclerView recycler = (RecyclerView) findViewById(R.id.recycler);
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        final TestAdapter adapter = new TestAdapter(this);
        recycler.setLayoutManager(manager);
        recycler.setAdapter(adapter);
        adapter.setContent(getMokeData(10));

        refreshContainer.setListener(new RefreshContainer.OnRefreshListener() {

            @Override
            public void onRefresh() {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    adapter.setContent(getMokeData(50));
                    refreshContainer.finishRefreshing();
                }
            }, 5000);
            }
        });
    }

    private List<String> getMokeData(int count) {
        List<String> list = new ArrayList<>();
        for(int i = 0; i < count; i++) {
            list.add("");
        }
        return list;
    }
}
