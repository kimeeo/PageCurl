package com.kimeeo.pagecurl;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import com.kimeeo.pagecurl.view.OnPageCurChangelListener;
import com.kimeeo.pagecurl.view.PageCurlLayout;

public class MainActivity2 extends Activity implements OnPageCurChangelListener {

	private PageCurlLayout pageCurlLayout;

	View page1, page2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		page1 = getLayoutInflater().inflate(R.layout.main_menu_hidden, null);

		page2 = getLayoutInflater().inflate(R.layout.main_menu_show, null);

		pageCurlLayout = new PageCurlLayout(this);
		pageCurlLayout.set2Pages(page1, page2);
		pageCurlLayout.setPageCurlEnabled(true);
		// pcl.setPageStateIsOpened(false);
		pageCurlLayout.setOnPageCurlListener(this);
		setContentView(pageCurlLayout);
	}
	@Override
	public void onPageClosed() {
		Toast.makeText(this, "Page Closed", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onPageOpened() {
		Toast.makeText(this, "Page Opened", Toast.LENGTH_SHORT).show();
	}

}
