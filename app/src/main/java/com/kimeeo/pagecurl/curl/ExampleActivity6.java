package com.kimeeo.pagecurl.curl;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;



import java.util.ArrayList;
import com.kimeeo.pagecurl.R;
import com.kimeeo.pagecurl.curl.handler.PageProviderHandler6;
import com.kimeeo.pagecurl.curl.provider.PageProvider6;
import com.kimeeo.pagecurl.curl.view.CurlRenderer;
import com.kimeeo.pagecurl.curl.view.CurlView;

public class ExampleActivity6 extends ActionBarActivity {
    private CurlView curlView;
    private PageProvider6 adapter6;
    private PageProviderHandler6 handler6;
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

        if (savedInstanceState != null && savedInstanceState.containsKey("index")) {
            index = savedInstanceState.getInt("index");
        }
        curlView = (CurlView) findViewById(R.id.curl_view);

        adapter6 = new PageProvider6();
        handler6 = new PageProviderHandler6(curlView);

        adapter6.setHandler(handler6);

        adapter6.setStrings(contents);
        adapter6.setBackStrings(backContents);




        curlView.setPageProvider(adapter6);
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
