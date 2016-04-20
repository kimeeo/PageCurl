package com.kimeeo.pagecurl.curl;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.kimeeo.pagecurl.R;
import com.kimeeo.pagecurl.curl.provider.ImagePageProvider;
import com.kimeeo.pagecurl.curl.view.CurlRenderer;
import com.kimeeo.pagecurl.curl.view.CurlView;

import java.util.ArrayList;



public class ExampleActivity2 extends ActionBarActivity {
    private CurlView curlView;
    private ImagePageProvider imagePageProvider;
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

        imagePageProvider = new ImagePageProvider();
        curlView.setPageProvider(imagePageProvider);

        ArrayList<Bitmap> bitmaps = new ArrayList<Bitmap>();
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.page1));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.page2));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.page1));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.page2));
        bitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.page1));

        ArrayList<Bitmap> backBitmaps = new ArrayList<Bitmap>();
        backBitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.page1));
        backBitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.page2));
        backBitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.page1));
        backBitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.page2));
        backBitmaps.add(BitmapFactory.decodeResource(getResources(), R.drawable.page1));

        imagePageProvider.setBitmaps(bitmaps);
        imagePageProvider.setBackBitmaps(backBitmaps);

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

}
