package com.kimeeo.pagecurl.curl;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.kimeeo.pagecurl.curl.provider.PageProvider5;
import com.kimeeo.pagecurl.R;
import com.kimeeo.pagecurl.curl.view.CurlRenderer;
import com.kimeeo.pagecurl.curl.view.CurlView;


public class ExampleActivity5 extends ActionBarActivity {
    private CurlView curlView;
    private PageProvider5 adapter5;
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

        adapter5 = new PageProvider5();
        curlView.setPageProvider(adapter5);

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
