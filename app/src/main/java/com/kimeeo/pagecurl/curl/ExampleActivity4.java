package com.kimeeo.pagecurl.curl;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import java.util.ArrayList;

import com.kimeeo.pagecurl.R;
import com.kimeeo.pagecurl.curl.provider.PageProvider4;
import com.kimeeo.pagecurl.curl.view.CurlRenderer;
import com.kimeeo.pagecurl.curl.view.CurlView;


public class ExampleActivity4 extends ActionBarActivity {
    private CurlView curlView;
    private PageProvider4 pageProvider4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_sub4);
        curlView = (CurlView) findViewById(R.id.curl_view);

        pageProvider4 = new PageProvider4(this);
        curlView.setPageProvider(pageProvider4);

        ArrayList<String> contents = new ArrayList<String>();
        contents.add("Loading...");
        contents.add("Loading...");
        contents.add("Loading...");
        contents.add("Loading...");
        contents.add("Loading...");
        contents.add("Loading...");
        contents.add("Loading...");
        contents.add("Loading...");


        ArrayList<String> backContents = new ArrayList<String>();
        backContents.add("Loading...");
        backContents.add("Loading...");
        backContents.add("Loading...");
        backContents.add("Loading...");
        backContents.add("Loading...");
        backContents.add("Loading...");
        backContents.add("Loading...");
        backContents.add("Loading...");

        pageProvider4.setStrings(contents);
        pageProvider4.setBackStrings(backContents);

        curlView.setSizeChangedObserver(new CurlView.SizeChangedObserver() {
            @Override
            public void onSizeChanged(int width, int height) {
                if (width > height) {
                    curlView.setViewMode(CurlRenderer.SHOW_TWO_PAGES);
                    curlView.setMargins(0.1f, 0f, 0.1f, 0f);
                } else {
                    curlView.setViewMode(CurlRenderer.SHOW_ONE_PAGE);
                }
            }
        });
    }



}
