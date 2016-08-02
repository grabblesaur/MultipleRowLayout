package recyclerview.sriyank.com.recyclerview.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import recyclerview.sriyank.com.recyclerview.R;
import recyclerview.sriyank.com.recyclerview.adapter.NavigationDrawerAdapter;
import recyclerview.sriyank.com.recyclerview.model.NavigationDrawerItem;

public class NavigationDrawerFragment extends Fragment {

    @BindView(R.id.nav_recyclerview)
    RecyclerView mNavRecyclerView;

    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
        ButterKnife.bind(this, view);

        setUpRecyclerView();

        return view;
    }

    private void setUpRecyclerView() {
        mNavRecyclerView.setAdapter(new NavigationDrawerAdapter(getActivity(), NavigationDrawerItem.getData()));
        mNavRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    public void setUpDrawer(int nav_drwr_fragment, DrawerLayout drawerLayout, Toolbar toolbar) {

        mDrawerLayout = drawerLayout;

        mDrawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar,
                R.string.drawer_open, R.string.drawer_close){

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);

        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });
    }
}
