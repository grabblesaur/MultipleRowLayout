package recyclerview.sriyank.com.recyclerview.app;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import recyclerview.sriyank.com.recyclerview.R;
import recyclerview.sriyank.com.recyclerview.adapter.RecyclerAdapter;
import recyclerview.sriyank.com.recyclerview.model.Landscape;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

		setUpToolbar();

        setUpDrawer();

		setUpRecyclerView();
	}

    private void setUpToolbar() {
        mToolbar.setTitle("Multiple Rows Layout Demo");
		mToolbar.inflateMenu(R.menu.menu_main);
	}

    private void setUpDrawer() {
		NavigationDrawerFragment fragment = (NavigationDrawerFragment) getSupportFragmentManager()
				.findFragmentById(R.id.nav_drwr_fragment);
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        fragment.setUpDrawer(R.id.nav_drwr_fragment, drawerLayout, mToolbar);
    }

	private void setUpRecyclerView() {

		RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
		RecyclerAdapter adapter = new RecyclerAdapter(Landscape.getData());
		recyclerView.setAdapter(adapter);

		LinearLayoutManager mLinearLayoutManagerVertical = new LinearLayoutManager(this); // (Context context, int spanCount)
		mLinearLayoutManagerVertical.setOrientation(LinearLayoutManager.VERTICAL);
		recyclerView.setLayoutManager(mLinearLayoutManagerVertical);

		recyclerView.setItemAnimator(new DefaultItemAnimator()); // Even if we don't use it then also our items shows default animation. #Check Docs
	}
}
