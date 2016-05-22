package com.jt.funny.homepage.app;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.jt.funny.homepage.ItemProperty;
import com.jt.funny.homepage.ItemTypeAdapter;
import com.jt.funny.homepage.ItemVO;
import com.jt.funny.homepage.ItemViewManager;
import com.jt.funny.homepage.app.widget.ItemViewImageView;
import com.jt.funny.homepage.app.widget.ItemViewTextView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContact.MainView {

    private ListView mListView;
    private ItemViewManager mViewManager;
    private ItemTypeAdapter mAdapter;

    private MainContact.MainPresenter mMainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mListView = (ListView) findViewById(android.R.id.list);
        mViewManager = ItemViewManager.getInstance();

        mViewManager.add("nullable", ItemViewManager.NULLABLE_ITEM_VIEW_PROPERTY);
        mViewManager.add("text", new ItemProperty(ItemViewTextView.ItemVO.class, ItemViewTextView.class));
        mViewManager.add("image", new ItemProperty(ItemViewImageView.ItemVO.class, ItemViewImageView.class));
        mViewManager.add("image", new ItemProperty(ItemViewImageView.ItemVO.class, ItemViewImageView.class));

        mAdapter = new ItemTypeAdapter(this, mViewManager);
        mListView.setAdapter(mAdapter);

        mMainPresenter = new MainPresenterImpl(this);
        mMainPresenter.request();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void updateData(List<ItemVO> data) {
        mAdapter.setData(data);
    }

    @Override
    public void showError() {

    }
}
