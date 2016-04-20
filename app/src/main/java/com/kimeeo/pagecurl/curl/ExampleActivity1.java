package com.kimeeo.pagecurl.curl;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import com.kimeeo.pagecurl.R;
import com.kimeeo.pagecurl.curl.provider.TextPageProvider;
import com.kimeeo.pagecurl.curl.view.CurlRenderer;
import com.kimeeo.pagecurl.curl.view.CurlView;

import java.util.ArrayList;



public class ExampleActivity1 extends ActionBarActivity {
    private CurlView curlView;
    private TextPageProvider textPageProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_sub4);
        curlView = (CurlView) findViewById(R.id.curl_view);

        textPageProvider = new TextPageProvider();
        curlView.setPageProvider(textPageProvider);

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

        textPageProvider.setStrings(contents);
        textPageProvider.setBackStrings(backContents);
        curlView.setSizeChangedObserver(new CurlView.SizeChangedObserver() {
            @Override
            public void onSizeChanged(int width, int height) {
                if (width > height) {
                    curlView.setViewMode(CurlRenderer.SHOW_TWO_PAGES);
                } else {
                    curlView.setViewMode(CurlRenderer.SHOW_ONE_PAGE);
                }
            }
        });
    }



}
