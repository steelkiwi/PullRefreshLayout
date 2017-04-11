package steelkiwi.com.pullrefreshlayout.rest.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by yaroslav on 4/11/17.
 */

public class PixabayResponse {
    @SerializedName("hits")
    private List<Hit> hits;

    public List<Hit> getHits() {
        return hits;
    }

    public void setHits(List<Hit> hits) {
        this.hits = hits;
    }
}
