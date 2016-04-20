package com.kimeeo.pagecurl;

import android.graphics.*;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.kimeeo.pagecurl.fairy.entity.Book;
import com.kimeeo.pagecurl.fairy.entity.Page;
import com.kimeeo.pagecurl.fairy.view.CurlPage;
import com.kimeeo.pagecurl.fairy.view.CurlView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_3);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }






    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        private Book currentBook;

        public PlaceholderFragment() {
        }

        private List<Page> fillContent() {
            List<Page> pages = new ArrayList<Page>();
            pages.add(new Page(R.drawable.page1, R.string.page_1));
            pages.add(new Page(R.drawable.page2, R.string.page_1));
            pages.add(new Page(R.drawable.page1, R.string.page_1));
            pages.add(new Page(R.drawable.page2, R.string.page_1));
            pages.add(new Page(R.drawable.page1, R.string.page_1));
            pages.add(new Page(R.drawable.page2, R.string.page_1));
            pages.add(new Page(R.drawable.page1, R.string.page_1));
            pages.add(new Page(R.drawable.page2, R.string.page_1));
            pages.add(new Page(R.drawable.page1, R.string.page_1));
            pages.add(new Page(R.drawable.page2, R.string.page_1));
            return pages;
        }

        private void prepareContent() {
            currentBook = new Book(fillContent());
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout._page_curl_fragment_main, container, false);
            CurlView curlView = (CurlView) rootView.findViewById(R.id.view);
            init(curlView);
            return rootView;
        }

        private void init(CurlView curlView) {
            if (curlView != null) {
                prepareContent();
                int index = 0;
                curlView.setPageProvider(new PageProvider());
                curlView.setSizeChangedObserver(new SizeChangedObserver());
                curlView.setCurrentIndex(index);
                curlView.setBackgroundColor(Color.WHITE);
                curlView.setViewMode(CurlView.SHOW_ONE_PAGE);
            }
        }

        /**
         * CurlView size changed observer.
         */
        private class SizeChangedObserver implements CurlView.SizeChangedObserver {
            public void onSizeChanged(int w, int h) {

            }
        }

        /**
         * Bitmap provider.
         */
        private class PageProvider implements CurlView.PageProvider {


            public int getPageCount() {
                if (currentBook != null && currentBook.getPages() != null) {
                    return currentBook.getPages().size();
                } else {
                    return 0;
                }
            }

            private Bitmap loadBitmap(int width, int height, int index) {

                Bitmap b = Bitmap.createBitmap(width, height,
                        Bitmap.Config.ARGB_8888);
                b.eraseColor(0xFFFFFFFF);

                Canvas c = new Canvas(b);
                Drawable d = getResources().getDrawable(currentBook.getPages().get(index).getPage());
                if (d != null) {
                    int margin = 1;
                    int border = 3;

                    Rect r = new Rect(margin, margin, width - margin, height - margin);

                    int imageWidth = r.width() - (border * 2);
                    int imageHeight = imageWidth * d.getIntrinsicHeight()
                            / d.getIntrinsicWidth();

                    if (imageHeight > r.height() - (border * 2)) {
                        imageHeight = r.height() - (border * 2);
                        imageWidth = imageHeight * d.getIntrinsicWidth()
                                / d.getIntrinsicHeight();
                    }

                    r.left += ((r.width() - imageWidth) / 2) - border;
                    r.right = r.left + imageWidth + border + border;
                    r.top += ((r.height() - imageHeight) / 2) - border;
                    r.bottom = r.top + imageHeight + border + border;

                    Paint p = new Paint();
                    p.setColor(Color.rgb(180, 180, 180));
                    c.drawRect(r, p);
                    r.left += border;
                    r.right -= border;
                    r.top += border;
                    r.bottom -= border;

                    d.setBounds(r);
                    d.draw(c);

                    return b;
                } else {
                    return null;
                }
            }

            public void updatePage(CurlPage page, int width, int height, int index) {

                Bitmap front = loadBitmap(width, height, index);
                page.setTexture(front, CurlPage.SIDE_FRONT);
                page.setColor(Color.rgb(180, 180, 180), CurlPage.SIDE_BACK);

                //Bitmap back = loadBitmap(width, height, index);
                //page.setTexture(back, CurlPage.SIDE_BACK);
            }
        }
    }


}
