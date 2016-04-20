package com.kimeeo.pagecurl.curl.handler;

import com.kimeeo.pagecurl.curl.provider.handler.BasePageProviderHandler;
import com.kimeeo.pagecurl.curl.view.CurlView;


/**
 * Created by rjhy on 14-11-26.
 */
public class PageProviderHandler6 extends BasePageProviderHandler {
    public PageProviderHandler6(CurlView curlView) {
        super(curlView);
    }

    @Override
    public Object onLoading(int index, boolean isBack) {
        return "Data Loading , please wait...";
    }

    @Override
    public Object onError(int index, boolean isBack) {
        return "Loading Error";
    }

    @Override
    public Object fetchData(int index, boolean isBack, Object data) throws Exception {
        Thread.sleep(2000);
        // not return null
        return data != null ? data : "";
    }
}
