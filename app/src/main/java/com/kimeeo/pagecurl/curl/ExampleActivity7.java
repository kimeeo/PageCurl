package com.kimeeo.pagecurl.curl;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.kimeeo.pagecurl.R;
import com.kimeeo.pagecurl.curl.handler.PageProviderHandler7;
import com.kimeeo.pagecurl.curl.provider.PageProvider7;
import com.kimeeo.pagecurl.curl.view.CurlRenderer;
import com.kimeeo.pagecurl.curl.view.CurlView;

import java.util.Arrays;
import java.util.List;



public class ExampleActivity7 extends ActionBarActivity {
    private CurlView curlView;
    private PageProvider7 adapter7;
    private PageProviderHandler7 handler7;
    private int index = 0;
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("index", curlView.getCurrentIndex());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_sub4);

        if (savedInstanceState != null && savedInstanceState.containsKey("index")) {
            index = savedInstanceState.getInt("index");
        }
        curlView = (CurlView) findViewById(R.id.curl_view);

        adapter7 = new PageProvider7();
        handler7 = new PageProviderHandler7(this, curlView);
        adapter7.setHandler(handler7);
        adapter7.setImages(getImages());

        curlView.setPageProvider(adapter7);
        curlView.setSizeChangedObserver(new CurlView.SizeChangedObserver() {
            @Override
            public void onSizeChanged(int width, int height) {
                if (width > height) {
                    curlView.setViewMode(CurlRenderer.SHOW_TWO_PAGES);
                    //percentage margin
                    curlView.setMargins(0.1f, 0f, 0.1f, 0f);
                } else {
                    curlView.setViewMode(CurlRenderer.SHOW_ONE_PAGE);
                }
            }
        });
        curlView.setCurrentIndex(index);
    }

    private List<String> getImages() {
        return Arrays.asList(imageThumbUrls);
    }



    public String[] imageThumbUrls = new String[] {
            "http://www.intrawallpaper.com/static/images/abstract-mosaic-background.png",
            "https://execrank.com/wp-content/uploads/2015/09/Geometric-Background-1024x800.jpg",
            "http://fox.graphics/files/large/abstract-autumn-background.jpg",
            "http://www.intrawallpaper.com/static/images/recycled_texture_background_by_sandeep_m-d6aeau9_PZ9chud.jpg",
            "http://www.intrawallpaper.com/static/images/abstract-mosaic-background.png",
            "https://execrank.com/wp-content/uploads/2015/09/Geometric-Background-1024x800.jpg",
            "http://fox.graphics/files/large/abstract-autumn-background.jpg",
            "http://www.intrawallpaper.com/static/images/recycled_texture_background_by_sandeep_m-d6aeau9_PZ9chud.jpg",
            "http://www.intrawallpaper.com/static/images/abstract-mosaic-background.png",
            "https://execrank.com/wp-content/uploads/2015/09/Geometric-Background-1024x800.jpg",
            "http://fox.graphics/files/large/abstract-autumn-background.jpg",
            "http://www.intrawallpaper.com/static/images/recycled_texture_background_by_sandeep_m-d6aeau9_PZ9chud.jpg"
    };

}
