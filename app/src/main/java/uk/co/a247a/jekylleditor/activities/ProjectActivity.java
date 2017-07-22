package uk.co.a247a.jekylleditor.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import uk.co.a247a.jekylleditor.R;
import uk.co.a247a.jekylleditor.fragments.FileBrowser;
import uk.co.a247a.jekylleditor.fragments.FileEditor;
import uk.co.a247a.jekylleditor.fragments.WebPreview;

public class ProjectActivity extends AppCompatActivity implements FileEditor.OnFragmentInteractionListener, FileBrowser.OnFragmentInteractionListener {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    public String ROOT_DIR = "rootDir";
    private String mRoot;
    private String mCurrentFile;
    private boolean mCurrentFileSaved;
    private String PREVIEW_HOME_URL = "http://localhost:4000";

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        if(getIntent()!=null){
            mRoot = getIntent().getStringExtra(ROOT_DIR);
        }

        if(mRoot==null){
            mRoot="/";
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Handle menu options
        switch (item.getItemId()) {
            //Open settings dialog-covers VCS
            case R.id.action_settings:
                return true;
            //Close current project
            case R.id.action_close:
            case R.id.action_restart:
            case R.id.action_start:
            case R.id.action_stop:
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onFileSaveStateChange(boolean fileSaved) {
        mCurrentFileSaved=fileSaved;
    }


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            switch (position) {
                case 0:
                    return FileBrowser.newInstance(mRoot);
                case 1:
                    return FileEditor.newInstance(mRoot+mCurrentFile);
                case 2:
                    return WebPreview.newInstance(PREVIEW_HOME_URL);
                default:
                    throw new IllegalArgumentException("Position " + position + " Out Of Bounds");
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "File browser";
                case 1:
                    return "File Editor";
                case 2:
                    return "Preview";
            }
            return null;
        }
    }
}
