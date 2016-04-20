package com.kimeeo.pagecurl.curl.provider;

import android.graphics.Bitmap;

import com.kimeeo.pagecurl.curl.provider.handler.BasePageProviderHandler;

import java.util.List;

/**
 * Created by rjhy on 14-11-26.
 */
public class PageProvider7 extends ImagePageProvider {

    private List<String> datas;

    public void setImages(List<String> datas) {
        this.datas = datas;
    }

    public void setHandler(BasePageProviderHandler handler) {
        this.handler = handler;
    }

    private BasePageProviderHandler handler;


    @Override
    public int getPageCount() {
        return datas != null ? datas.size() : 0;
    }

    @Override
    public Bitmap getItem(int index, boolean isBack) {
        if (isBack) {
            return (Bitmap)handler.getItem(index, isBack, datas.get(datas.size()-1-index));
        } else {
            return (Bitmap)handler.getItem(index, isBack, datas.get(index));
        }
    }
}
