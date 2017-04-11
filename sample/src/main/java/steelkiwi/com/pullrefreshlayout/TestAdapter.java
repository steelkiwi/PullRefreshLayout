package steelkiwi.com.pullrefreshlayout;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.picasso.transformations.BlurTransformation;
import steelkiwi.com.pullrefreshlayout.rest.dto.Hit;

/**
 * Created by yaroslav on 2/22/17.
 */

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.ViewHolder> {

    private Context context;
    private List<Hit> list = new ArrayList<>();


    public TestAdapter(Context context) {
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.general_feed_item_layout, parent, false);
        return new ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Hit hit = list.get(position);
        String image = hit.getImage();
        if(image != null) {
            Picasso.with(context).load(image).into(holder.ivGeneralFeedImage);
            Picasso.with(context).load(image).transform(new BlurTransformation(context)).into(holder.ivGeneralFeedImageBlur);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setContent(List<Hit> list){
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivGeneralFeedImage;
        ImageView ivGeneralFeedImageBlur;

        public ViewHolder(View itemView) {
            super(itemView);
            ivGeneralFeedImage = (ImageView) itemView.findViewById(R.id.ivGeneralFeedImage);
            ivGeneralFeedImageBlur = (ImageView) itemView.findViewById(R.id.ivGeneralFeedImageBlur);
        }
    }
}
