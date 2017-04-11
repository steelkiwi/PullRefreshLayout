package steelkiwi.com.pullrefreshlayout.rest.dto;

import com.google.gson.annotations.SerializedName;

/**
 * Created by yaroslav on 4/11/17.
 */

public class Hit {
    @SerializedName("webformatURL")
    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
