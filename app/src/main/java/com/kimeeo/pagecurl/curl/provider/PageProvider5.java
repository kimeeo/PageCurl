package com.kimeeo.pagecurl.curl.provider;


/**
 * Created by rjhy on 14-11-26.
 */
public class PageProvider5 extends TextPageProvider {

    @Override
    public String getItem(int index, boolean isBack) {
        if (index%2 == 0) {
            return "Article" + index + "Content";
        } else {
            return null;
        }
    }

    @Override
    public int getPageCount() {
        return Integer.MAX_VALUE;
    }
}
