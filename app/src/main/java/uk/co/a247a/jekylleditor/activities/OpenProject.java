package uk.co.a247a.jekylleditor.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import uk.co.a247a.jekylleditor.R;

public class OpenProject extends AppCompatActivity {
    private ListView mFolderView;
    private TextView mBreadCrums;
    private Button mOpenProject;

    private String mCurrentDir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_project);


        mOpenProject = (Button) findViewById(R.id.open_project);
        mOpenProject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OpenProject.this, ProjectActivity.class));
            }
        });

        mBreadCrums = (TextView) findViewById(R.id.breadCrums);
        mBreadCrums.setText(mCurrentDir);
        mFolderView = (ListView) findViewById(R.id.FileFolderList);
        String[] FilesAndFolders = new String[]{"Android List View",
                "Adapter implementation",
                "Simple List View In Android",
                "Create List View Android",
                "Android Example",
                "List View Source Code",
                "List View Array Adapter",
                "Android Example List View"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, FilesAndFolders);
        mFolderView.setAdapter(adapter);
        // ListView Item Click Listener
        mFolderView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // ListView Clicked item value
                String itemValue = (String) mFolderView.getItemAtPosition(position);
            }

        });


    }
}
