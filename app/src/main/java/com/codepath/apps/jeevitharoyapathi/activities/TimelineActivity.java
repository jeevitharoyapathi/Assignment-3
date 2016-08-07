package com.codepath.apps.jeevitharoyapathi.activities;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.codepath.apps.jeevitharoyapathi.R;
import com.codepath.apps.jeevitharoyapathi.adapters.TweetsAdapter;
import com.codepath.apps.jeevitharoyapathi.fragment.ComposeDialogFragment;
import com.codepath.apps.jeevitharoyapathi.models.Tweet;
import com.codepath.apps.jeevitharoyapathi.restClient.TwitterApplication;
import com.codepath.apps.jeevitharoyapathi.restClient.TwitterClient;
import com.codepath.apps.jeevitharoyapathi.utils.EndlessRecyclerViewScrollListener;
import com.google.android.gms.common.api.GoogleApiClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cz.msebera.android.httpclient.Header;

public class TimelineActivity extends AppCompatActivity implements ComposeDialogFragment.NewTweetListener {

    private TwitterClient client;
    private ArrayList<Tweet> mTweets;
    private TweetsAdapter mAdapter;
    private LinearLayoutManager mLinearLayoutManager;
    private EndlessRecyclerViewScrollListener mEndlessRecyclerViewScrollListener;
    @BindView(R.id.rvResult)
    RecyclerView mRecyclerView;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.fab_add)
    FloatingActionButton mFavAdd;

    private GoogleApiClient mClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Twitter");
        client = TwitterApplication.getRestClient();
        mTweets = new ArrayList<>();
        mAdapter = new TweetsAdapter(this, mTweets);
        mRecyclerView.setAdapter(mAdapter);
        mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mEndlessRecyclerViewScrollListener = new EndlessRecyclerViewScrollListener(mLinearLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount) {
                populateTimeline();
            }
        };
        mRecyclerView.addOnScrollListener(mEndlessRecyclerViewScrollListener);
        populateTimeline();
    }

    private void populateTimeline() {
        client.getHomeTimeline(new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {

                mTweets.addAll(Tweet.fromJsonArray(response));
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject erroResponse) {
                Log.e("jeevitha", erroResponse.toString());
            }
        }, mAdapter.getLastTweetId());


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.fab_add)
    void createNewTweet() {
        DialogFragment composeDialogFragment = ComposeDialogFragment.newInstance(this);
        composeDialogFragment.show(getFragmentManager().beginTransaction(), "Tweet");
    }

    @Override
    public void onNewTweet() {

    }
}
